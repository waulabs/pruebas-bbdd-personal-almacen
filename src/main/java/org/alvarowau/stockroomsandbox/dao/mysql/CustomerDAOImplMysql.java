package org.alvarowau.stockroomsandbox.dao.mysql;

import org.alvarowau.stockroomsandbox.bbdd.MysqlConnection;
import org.alvarowau.stockroomsandbox.dao.CustomerDAO;
import org.alvarowau.stockroomsandbox.models.AccountStatus;
import org.alvarowau.stockroomsandbox.models.Customer;
import org.alvarowau.stockroomsandbox.models.Purchase;
import org.alvarowau.stockroomsandbox.models.SubscriptionType;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImplMysql implements CustomerDAO {

    private MysqlConnection mysql;

    public CustomerDAOImplMysql() {
        mysql = new MysqlConnection();
    }

    @Override
    public Customer save(Customer entity) {
        Customer newCustomer = null;
        String sql = SqlQueriesMysql.CUSTOMER_INSERT;
        try (Connection connection = mysql.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getNumberPhone());
            preparedStatement.setString(4, entity.getEmail());
            preparedStatement.setString(5, entity.getAddress());
            preparedStatement.setDate(6, java.sql.Date.valueOf(entity.getBirthDate()));
            preparedStatement.setString(7, entity.getGender());
            preparedStatement.setString(8, entity.getPersonalId());
            preparedStatement.setString(9, entity.getNationality());
            preparedStatement.setString(10, entity.getUserName());
            preparedStatement.setString(11, entity.getPassword()); // Ya está hasheada
            preparedStatement.setString(12, entity.getAccountStatus().name());
            preparedStatement.setString(13, entity.getPreferredPaymentMethod());
            preparedStatement.setString(14, entity.getSubscriptionType().name());
            preparedStatement.setString(15, entity.getShippingAddress());
            preparedStatement.setString(16, entity.getBillingAddress());

            // Ejecuta la inserción en la base de datos
            int affectedRows = preparedStatement.executeUpdate();

            // Verifica si la inserción fue exitosa
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idCustomer = generatedKeys.getInt(1);

                        // Consulta para obtener la fecha de registro desde la base de datos
                        String selectQuery = "SELECT registrationDate FROM Customer WHERE idCustomer = ?";
                        try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
                            selectStmt.setInt(1, idCustomer);
                            try (ResultSet rs = selectStmt.executeQuery()) {
                                if (rs.next()) {
                                    LocalDate registrationDate = rs.getDate("registrationDate").toLocalDate();

                                    // Construir el objeto Customer con la fecha de registro
                                    newCustomer = new Customer(
                                            idCustomer,
                                            entity.getFirstName(),
                                            entity.getLastName(),
                                            entity.getNumberPhone(),
                                            entity.getEmail(),
                                            entity.getAddress(),
                                            entity.getBirthDate(),
                                            entity.getGender(),
                                            entity.getPersonalId(),
                                            entity.getNationality(),
                                            registrationDate,  // Fecha de registro obtenida
                                            entity.getUserName(),
                                            entity.getPassword(),
                                            entity.getLoyaltyPoints(),
                                            entity.getAccountStatus(),
                                            entity.getLastLoginDate(),
                                            entity.getPreferredPaymentMethod(),
                                            entity.getSubscriptionType(),
                                            entity.getShippingAddress(),
                                            entity.getBillingAddress(),
                                            entity.getPurchaseHistory()
                                    );
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return newCustomer;
    }

    @Override
    public boolean update(Customer entity) {
        boolean isUpdated = false;
        String sql = SqlQueriesMysql.CUSTOMER_UPDATE;
        try (Connection connection = mysql.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getNumberPhone());
            preparedStatement.setString(4, entity.getEmail());
            preparedStatement.setString(5, entity.getAddress());
            preparedStatement.setDate(6, java.sql.Date.valueOf(entity.getBirthDate()));
            preparedStatement.setString(7, entity.getGender());
            preparedStatement.setString(8, entity.getPersonalId());
            preparedStatement.setString(9, entity.getNationality());
            preparedStatement.setString(10, entity.getUserName());
            preparedStatement.setString(11, entity.getPassword()); // Ya está hasheada
            preparedStatement.setString(12, entity.getAccountStatus().name());
            preparedStatement.setString(13, entity.getPreferredPaymentMethod());
            preparedStatement.setString(14, entity.getSubscriptionType().name());
            preparedStatement.setString(15, entity.getShippingAddress());
            preparedStatement.setString(16, entity.getBillingAddress());
            preparedStatement.setInt(17, entity.getIdPerson()); // Asegúrate de que el ID sea el último parámetro

            int affectedRows = preparedStatement.executeUpdate();
            isUpdated = affectedRows > 0;
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Integer id) {
        boolean isDeleted = false;
        String sql = SqlQueriesMysql.CUSTOMER_DELETE;
        try (Connection connection = mysql.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            isDeleted = affectedRows > 0;
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return isDeleted;
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = null;
        String sql = SqlQueriesMysql.CUSTOMER_SELECT_BY_ID;
        try (Connection connection = mysql.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    customer = createCustomerFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = SqlQueriesMysql.CUSTOMER_SELECT_ALL;
        try (Connection connection = mysql.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = createCustomerFromResultSet(resultSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return customers;
    }

    private Customer createCustomerFromResultSet(ResultSet set) throws SQLException {
        Integer idPerson = set.getInt("idCustomer");
        String firstName = set.getString("firstName");
        String lastName = set.getString("lastName");
        String numberPhone = set.getString("numberPhone");
        String email = set.getString("email");
        String address = set.getString("address");

        // Manejo de fecha de nacimiento
        LocalDate birthDate = null;
        java.sql.Date birthDateSql = set.getDate("birthDate");
        if (birthDateSql != null) {
            birthDate = birthDateSql.toLocalDate();
        }

        String gender = set.getString("gender");
        String personalId = set.getString("personalId");
        String nationality = set.getString("nationality");

        // Manejo de fecha de registro
        LocalDate registrationDate = null;
        java.sql.Date registrationDateSql = set.getDate("registrationDate");
        if (registrationDateSql != null) {
            registrationDate = registrationDateSql.toLocalDate();
        }

        String userName = set.getString("userName");
        String password = set.getString("password");
        int loyaltyPoints = set.getInt("loyaltyPoints");

        // Manejo de estado de cuenta
        AccountStatus accountStatus = null;
        String accountStatusStr = set.getString("accountStatus");
        if (accountStatusStr != null) {
            accountStatus = AccountStatus.valueOf(accountStatusStr);
        }

        // Manejo de fecha y hora del último inicio de sesión
        LocalDateTime lastLoginDate = null;
        java.sql.Timestamp lastLoginTimestamp = set.getTimestamp("lastLoginDate");
        if (lastLoginTimestamp != null) {
            lastLoginDate = lastLoginTimestamp.toLocalDateTime();
        }

        String preferredPaymentMethod = set.getString("preferredPaymentMethod");

        // Manejo del tipo de suscripción
        SubscriptionType subscriptionType = null;
        String subscriptionTypeStr = set.getString("subscriptionType");
        if (subscriptionTypeStr != null) {
            subscriptionType = SubscriptionType.valueOf(subscriptionTypeStr);
        }

        String shippingAddress = set.getString("shippingAddress");
        String billingAddress = set.getString("billingAddress");

        // Manejo del historial de compras
        List<Purchase> purchaseHistory = null; // Manejar como sea necesario

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
