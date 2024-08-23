package org.alvarowau.stockroomsandbox.models;

import java.util.Objects;

public class Purchase {

    private Integer idPurchase;          // Identificador único de la compra
    private Product product;             // Producto comprado
    private Integer quantity;            // Cantidad de productos comprados
    private Double unitPrice;            // Precio por unidad del producto en el momento de la compra
    private String productName;          // Nombre del producto en el momento de la compra
    private String productDescription;   // Descripción del producto en el momento de la compra
    private Double totalPrice;           // Precio total (quantity * unitPrice)

    // Constructor
    public Purchase(Integer idPurchase, Product product, Integer quantity) {
        this.idPurchase = idPurchase;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = product.getPrice();  // Precio actual del producto
        this.productName = product.getName();  // Nombre actual del producto
        this.productDescription = product.getDescription(); // Descripción actual del producto
        this.totalPrice = quantity * unitPrice;
    }

    // Getters y Setters
    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.unitPrice = product.getPrice();
        this.productName = product.getName();
        this.productDescription = product.getDescription();
        this.totalPrice = this.quantity * this.unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        this.totalPrice = this.quantity * this.unitPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        this.totalPrice = this.quantity * this.unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(idPurchase, purchase.idPurchase) &&
                Objects.equals(product, purchase.product) &&
                Objects.equals(quantity, purchase.quantity) &&
                Objects.equals(unitPrice, purchase.unitPrice) &&
                Objects.equals(productName, purchase.productName) &&
                Objects.equals(productDescription, purchase.productDescription) &&
                Objects.equals(totalPrice, purchase.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPurchase, product, quantity, unitPrice, productName, productDescription, totalPrice);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "idPurchase=" + idPurchase +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
