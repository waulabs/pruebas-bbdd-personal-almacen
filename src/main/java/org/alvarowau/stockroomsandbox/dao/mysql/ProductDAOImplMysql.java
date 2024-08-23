package org.alvarowau.stockroomsandbox.dao.mysql;

import org.alvarowau.stockroomsandbox.bbdd.MysqlConnection;
import org.alvarowau.stockroomsandbox.dao.ProductDAO;
import org.alvarowau.stockroomsandbox.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImplMysql implements ProductDAO {

    private final MysqlConnection mysql;

    public ProductDAOImplMysql() {
        mysql = new MysqlConnection(); // Asumiendo que MysqlConnection está configurado para usar HikariCP
    }

    @Override
    public Product save(Product entity) {
        String sql = SqlQueriesMysql.PRODUCT_INSERT;
        try (Connection connection = mysql.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entity.getCode());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setInt(4, entity.getStock());
            preparedStatement.setBoolean(5, entity.getStatus());
            preparedStatement.setDouble(6, entity.getPrice());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int lastInsertedId = generatedKeys.getInt(1);
                        entity.setIdProduct(lastInsertedId);
                    }
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return entity;
    }

    @Override
    public boolean update(Product entity) {
        String sql = SqlQueriesMysql.PRODUCT_UPDATE;
        try (Connection connection = mysql.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, entity.getCode());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getDescription());
            statement.setInt(4, entity.getStock());
            statement.setBoolean(5, entity.getStatus());
            statement.setDouble(6, entity.getPrice());
            statement.setInt(7, entity.getIdProduct());

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = SqlQueriesMysql.PRODUCT_DELETE;
        try (Connection connection = mysql.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        Product product = null;
        String sql = SqlQueriesMysql.PRODUCT_SELECT_BY_ID;
        try (Connection connection = mysql.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    product = createProductFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = SqlQueriesMysql.PRODUCT_SELECT_ALL;
        try (Connection connection = mysql.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Product product = createProductFromResultSet(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return products;
    }

    private Product createProductFromResultSet(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getInt("idProduct"),
                resultSet.getString("code"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getInt("stock"),
                resultSet.getBoolean("status"),
                resultSet.getDouble("price")
        );
    }

    private void handleSQLException(SQLException e) {
        System.err.println("SQL Error Code: " + e.getErrorCode());
        System.err.println("SQL State: " + e.getSQLState());
        System.err.println("Message: " + e.getMessage());
        e.printStackTrace();
    }
}
