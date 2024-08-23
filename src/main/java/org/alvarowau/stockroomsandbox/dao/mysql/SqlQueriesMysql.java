package org.alvarowau.stockroomsandbox.dao.mysql;

public class SqlQueriesMysql {
    // Consultas para la tabla Customer
    public static final String CUSTOMER_INSERT =
            "INSERT INTO Customer (firstName, lastName, numberPhone, email, address, birthDate, gender, personalId, nationality, userName, password, accountStatus, preferredPaymentMethod, subscriptionType, shippingAddress, billingAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String CUSTOMER_SELECT_BY_ID =
            "SELECT * FROM Customer WHERE idCustomer = ?";

    public static final String CUSTOMER_SELECT_ALL =
            "SELECT * FROM Customer";

    public static final String CUSTOMER_UPDATE =
            "UPDATE Customer SET firstName = ?, lastName = ?, numberPhone = ?, email = ?, address = ?, birthDate = ?, gender = ?, personalId = ?, nationality = ?, userName = ?, password = ?, accountStatus = ?, preferredPaymentMethod = ?, subscriptionType = ?, shippingAddress = ?, billingAddress = ? WHERE idCustomer = ?";

    public static final String CUSTOMER_DELETE =
            "DELETE FROM Customer WHERE idCustomer = ?";

    // Consultas para la tabla Product
    public static final String PRODUCT_INSERT =
            "INSERT INTO Product (code, name, description, stock, status, price) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String PRODUCT_SELECT_BY_ID =
            "SELECT * FROM Product WHERE idProduct = ?";

    public static final String PRODUCT_SELECT_ALL =
            "SELECT * FROM Product";

    public static final String PRODUCT_UPDATE =
            "UPDATE Product SET code = ?, name = ?, description = ?, stock = ?, status = ?, price = ? WHERE idProduct = ?";

    public static final String PRODUCT_DELETE =
            "DELETE FROM Product WHERE idProduct = ?";

    // Consultas para la tabla Sale
    public static final String SALE_INSERT =
            "INSERT INTO Sale (saleDate, totalAmount, customerId) VALUES (?, ?, ?)";

    public static final String SALE_SELECT_BY_ID =
            "SELECT * FROM Sale WHERE idSale = ?";

    public static final String SALE_SELECT_ALL =
            "SELECT * FROM Sale";

    public static final String SALE_UPDATE =
            "UPDATE Sale SET saleDate = ?, totalAmount = ?, customerId = ? WHERE idSale = ?";

    public static final String SALE_DELETE =
            "DELETE FROM Sale WHERE idSale = ?";

    // Consultas para la tabla Purchase
    public static final String PURCHASE_INSERT =
            "INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public static final String PURCHASE_SELECT_BY_ID =
            "SELECT * FROM Purchase WHERE idPurchase = ?";

    public static final String PURCHASE_SELECT_ALL =
            "SELECT * FROM Purchase";

    public static final String PURCHASE_UPDATE =
            "UPDATE Purchase SET saleId = ?, productId = ?, quantity = ?, unitPrice = ?, productName = ?, productDescription = ?, totalPrice = ? WHERE idPurchase = ?";

    public static final String PURCHASE_DELETE =
            "DELETE FROM Purchase WHERE idPurchase = ?";
}
