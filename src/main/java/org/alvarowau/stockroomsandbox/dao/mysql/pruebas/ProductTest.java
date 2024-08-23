package org.alvarowau.stockroomsandbox.dao.mysql.pruebas;

import org.alvarowau.stockroomsandbox.dao.mysql.ProductDAOImplMysql;
import org.alvarowau.stockroomsandbox.models.Product;

import java.util.List;

public class ProductTest {

    private static Product savedProduct;

    private static void testSaveProduct() {
        ProductDAOImplMysql mysql = new ProductDAOImplMysql();
        Product newProduct = new Product(
                null,          // ID will be generated automatically
                "ABC123",      // Product code
                "Sample Product", // Product name
                "Description of the test product", // Description
                100,           // Stock quantity
                true,          // Product status
                19.99          // Product price
        );
        // Save the new product to the database
        savedProduct = mysql.save(newProduct);  // Assign the saved product to the static variable
        System.out.println("Product saved: " + savedProduct);
    }

    private static void testDeleteProduct() {
        ProductDAOImplMysql mysql = new ProductDAOImplMysql();
        if (savedProduct != null) {
            int id = savedProduct.getIdProduct();
            if (mysql.delete(id)) {
                System.out.println("Product deleted");
            } else {
                System.out.println("Product not deleted");
            }
        } else {
            System.out.println("Cannot delete, product not saved.");
        }
    }

    private static void testFindProductById() {
        ProductDAOImplMysql mysql = new ProductDAOImplMysql();
        Product product = mysql.findById(3);
        System.out.println(product);
    }

    private static void testFindAllProducts() {
        ProductDAOImplMysql mysql = new ProductDAOImplMysql();
        List<Product> products = mysql.findAll();
        if (products != null) {
            for (Product a : products) {
                System.out.println(a);
            }
        } else {
            System.out.println("No products found.");
        }
    }

    private static void testUpdateProduct() {
        ProductDAOImplMysql mysql = new ProductDAOImplMysql();
        if (savedProduct != null) {
            savedProduct.setDescription("This is an updated description");
            if (mysql.update(savedProduct)) {
                System.out.println("Product with ID " + savedProduct.getIdProduct() + " updated");
            } else {
                System.out.println("Product with ID " + savedProduct.getIdProduct() + " not updated");
            }
        } else {
            System.out.println("Cannot update, product not saved.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing find product by ID with ID 3");
        testFindProductById();

        System.out.println("\nTesting find all products");
        testFindAllProducts();

        System.out.println("\nTesting save product");
        testSaveProduct();

        System.out.println("\nTesting update product with ID " + (savedProduct != null ? savedProduct.getIdProduct() : "null"));
        testUpdateProduct();

        System.out.println("\nTesting delete product with ID " + (savedProduct != null ? savedProduct.getIdProduct() : "null"));
        testDeleteProduct();
    }
}
