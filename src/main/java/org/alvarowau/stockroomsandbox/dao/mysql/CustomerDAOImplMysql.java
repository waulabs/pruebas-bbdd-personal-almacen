package org.alvarowau.stockroomsandbox.dao.mysql;

import org.alvarowau.stockroomsandbox.bbdd.MysqlConnection;
import org.alvarowau.stockroomsandbox.dao.CustomerDAO;
import org.alvarowau.stockroomsandbox.models.AccountStatus;
import org.alvarowau.stockroomsandbox.models.Customer;
import org.alvarowau.stockroomsandbox.models.Purchase;
import org.alvarowau.stockroomsandbox.models.SubscriptionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImplMysql implements CustomerDAO {

    private final MysqlConnection mysql;

    public CustomerDAOImplMysql(){
        mysql = new MysqlConnection();
    }
    @Override
    public Customer save(Customer entity) {
        return null;
    }

    @Override
    public boolean update(Customer entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Customer findById(Integer integer) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = mysql.getDatabaseConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueriesMysql.CUSTOMER_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer = createCustomerFromResultSet(resultSet);
                customers.add(customer);
            }
        }catch (SQLException e){
            handleSQLException(e);
        }
        return customers;
    }

    private Customer createCustomerFromResultSet(ResultSet set) throws SQLException {
        // Extraemos los campos básicos de la clase Person
        Integer idPerson = set.getInt("idCustomer");
        String firstName = set.getString("firstName");
        String lastName = set.getString("lastName");
        String numberPhone = set.getString("numberPhone");
        String email = set.getString("email");
        String address = set.getString("address");
        LocalDate birthDate = set.getDate("birthDate").toLocalDate();
        String gender = set.getString("gender");
        String personalId = set.getString("personalId");
        String nationality = set.getString("nationality");
        LocalDate registrationDate = set.getDate("registrationDate").toLocalDate();

        // Extraemos los campos adicionales específicos de Customer
        String userName = set.getString("userName");
        String password = set.getString("password");
        int loyaltyPoints = set.getInt("loyaltyPoints");
        AccountStatus accountStatus = AccountStatus.valueOf(set.getString("accountStatus"));
        LocalDateTime lastLoginDate = set.getTimestamp("lastLoginDate").toLocalDateTime();
        String preferredPaymentMethod = set.getString("preferredPaymentMethod");
        SubscriptionType subscriptionType = SubscriptionType.valueOf(set.getString("subscriptionType"));
        String shippingAddress = set.getString("shippingAddress");
        String billingAddress = set.getString("billingAddress");

        // La lista de compras puede ser nula o vacía, así que la manejamos por defecto
        List<Purchase> purchaseHistory = null;

        // Creamos y retornamos un nuevo objeto Customer
        return new Customer(
                idPerson, firstName, lastName, numberPhone, email, address,
                birthDate, gender, personalId, nationality, registrationDate,
                userName, password, loyaltyPoints, accountStatus,
                lastLoginDate, preferredPaymentMethod, subscriptionType,
                shippingAddress, billingAddress, purchaseHistory
        );
    }


    private void handleSQLException(SQLException e) {
        System.out.println("Error Code: " + e.getErrorCode());
        System.out.println("Cause: " + e.getCause());
        System.out.println("Message: " + e.getMessage());
    }
}
