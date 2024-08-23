package org.alvarowau.stockroomsandbox.models;

import java.util.Objects;

public class Product {

    private Integer idProduct;    // Identificador único del producto
    private String code;         // Código único del producto
    private String name;         // Nombre del producto
    private String description;  // Descripción del producto
    private Integer stock;       // Cantidad en stock
    private Boolean status;      // Estado del producto (por ejemplo, disponible o no disponible)
    private Double price;        // Precio del producto

    // Constructor sin id
    public Product(String code, String name, String description, Integer stock, Boolean status, Double price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.status = status;
        this.price = price;
    }

    // Constructor con id
    public Product(Integer idProduct, String code, String name, String description, Integer stock, Boolean status, Double price) {
        this(code, name, description, stock, status, price);
        this.idProduct = idProduct;
    }

    // Constructor vacío
    public Product() {
    }

    // Getters y Setters
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(code, product.code) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(stock, product.stock) &&
                Objects.equals(status, product.status) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, description, stock, status, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
