package org.alvarowau.stockroomsandbox.models;

import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Customer extends Person {

    private String userName;
    private String password;
    private int loyaltyPoints;
    private AccountStatus accountStatus;
    private LocalDateTime lastLoginDate;
    private String preferredPaymentMethod;
    private SubscriptionType subscriptionType;
    private String shippingAddress;
    private String billingAddress;
    private List<Purchase> purchaseHistory;

    public Customer() {
        // Constructor por defecto
    }

    public Customer(String firstName, String lastName, int numberPhone, String email, String address, LocalDate birthDate,
                    String gender, String personalId, String nationality,
                    String userName, String password, int loyaltyPoints, AccountStatus accountStatus,
                    LocalDateTime lastLoginDate, String preferredPaymentMethod, SubscriptionType subscriptionType,
                    String shippingAddress, String billingAddress, List<Purchase> purchaseHistory) {
        super(firstName, lastName, numberPhone, email, address, birthDate, gender, personalId, nationality);
        this.userName = userName;
        this.password = hashPassword(password); // Hash de la contraseña
        this.loyaltyPoints = loyaltyPoints;
        this.accountStatus = accountStatus;
        this.lastLoginDate = lastLoginDate;
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.subscriptionType = subscriptionType;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.purchaseHistory = purchaseHistory;
    }

    public Customer(Integer idPerson, String firstName, String lastName, int numberPhone, String email, String address,
                    LocalDate birthDate, String gender, String personalId, String nationality, LocalDate registrationDate,
                    String userName, String password, int loyaltyPoints, AccountStatus accountStatus,
                    LocalDateTime lastLoginDate, String preferredPaymentMethod, SubscriptionType subscriptionType,
                    String shippingAddress, String billingAddress, List<Purchase> purchaseHistory) {
        super(idPerson, firstName, lastName, numberPhone, email, address, birthDate, gender, personalId, nationality, registrationDate);
        this.userName = userName;
        this.password = hashPassword(password); // Hash de la contraseña
        this.loyaltyPoints = loyaltyPoints;
        this.accountStatus = accountStatus;
        this.lastLoginDate = lastLoginDate;
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.subscriptionType = subscriptionType;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.purchaseHistory = purchaseHistory;
    }

    // Métodos para manejar contraseñas
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String rawPassword) {
        return BCrypt.checkpw(rawPassword, this.password);
    }

    // Getters y setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password); // Hash de la contraseña
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }


}
