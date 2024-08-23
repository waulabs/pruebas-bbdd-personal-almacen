package org.alvarowau.stockroomsandbox.dao.mysql.pruebas;

import org.alvarowau.stockroomsandbox.dao.mysql.ProductDAOImplMysql;
import org.alvarowau.stockroomsandbox.models.Product;

import java.util.List;

public class ProductTest {

    private static ProductDAOImplMysql productDao = new ProductDAOImplMysql();
    private static Product savedProduct;

    private static void testSaveProduct() {
        Product newProduct = new Product(
                null,            // ID will be generated automatically
                "ABC123",        // Product code
                "Sample Product", // Product name
                "Description of the test product", // Description
                100,             // Stock quantity
                true,            // Product status
                19.99            // Product price
        );
        // Save the new product to the database
        savedProduct = productDao.save(newProduct);  // Assign the saved product to the static variable
        System.out.println("Product saved: " + savedProduct);
    }

    private static void testDeleteProduct() {
        if (savedProduct != null) {
            int id = savedProduct.getIdProduct();
            if (productDao.delete(id)) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Failed to delete product.");
            }
        } else {
            System.out.println("Cannot delete, product not saved.");
        }
    }

    private static void testFindProductById() {
        int testId = 3; // Use a known test ID or ensure it exists in the database
        Product product = productDao.findById(testId);
        if (product != null) {
            System.out.println("Product found: " + product);
        } else {
            System.out.println("Product with ID " + testId + " not found.");
        }
    }

    private static void testFindAllProducts() {
        List<Product> products = productDao.findAll();
        if (products != null && !products.isEmpty()) {
            System.out.println("All products:");
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("No products found.");
        }
    }

    private static void testUpdateProduct() {
        if (savedProduct != null) {
            savedProduct.setDescription("This is an updated description");
            if (productDao.update(savedProduct)) {
                System.out.println("Product with ID " + savedProduct.getIdProduct() + " updated successfully.");
            } else {
                System.out.println("Failed to update product with ID " + savedProduct.getIdProduct() + ".");
            }
        } else {
            System.out.println("Cannot update, product not saved.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing save product:");
        testSaveProduct();

        System.out.println("\nTesting find all products:");
        testFindAllProducts();

        System.out.println("\nTesting update product:");
        testUpdateProduct();

        System.out.println("\nTesting find product by ID:");
        testFindProductById();

        System.out.println("\nTesting delete product:");
        testDeleteProduct();
    }
}
