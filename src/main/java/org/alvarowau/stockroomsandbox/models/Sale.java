package org.alvarowau.stockroomsandbox.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Sale {

    private Integer idSale;            // Identificador único de la venta
    private LocalDate saleDate;        // Fecha de la venta
    private Double totalAmount;        // Monto total de la venta
    private Customer customer;         // Cliente que realizó la compra
    private List<Purchase> purchases;  // Detalles de los productos comprados

    // Constructor que acepta una lista de compras y calcula el totalAmount
    public Sale(Integer idSale, LocalDate saleDate, Customer customer, List<Purchase> purchases) {
        this.idSale = idSale;
        this.saleDate = saleDate;
        this.customer = customer;
        this.purchases = purchases;
        this.totalAmount = calculateTotalAmount();
    }

    // Método para calcular el monto total a partir de la lista de compras
    private Double calculateTotalAmount() {
        return purchases.stream()
                .mapToDouble(Purchase::getTotalPrice)
                .sum();
    }

    // Getters y Setters
    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
        this.totalAmount = calculateTotalAmount();  // Recalcula el totalAmount si cambian las compras
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(idSale, sale.idSale) &&
                Objects.equals(saleDate, sale.saleDate) &&
                Objects.equals(totalAmount, sale.totalAmount) &&
                Objects.equals(customer, sale.customer) &&
                Objects.equals(purchases, sale.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSale, saleDate, totalAmount, customer, purchases);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "idSale=" + idSale +
                ", saleDate=" + saleDate +
                ", totalAmount=" + totalAmount +
                ", customer=" + customer +
                ", purchases=" + purchases +
                '}';
    }
}
