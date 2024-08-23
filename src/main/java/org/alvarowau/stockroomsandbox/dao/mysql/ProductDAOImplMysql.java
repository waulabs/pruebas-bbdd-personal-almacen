package org.alvarowau.stockroomsandbox.dao.mysql;

import org.alvarowau.stockroomsandbox.bbdd.MysqlConnection;
import org.alvarowau.stockroomsandbox.dao.ProductDAO;
import org.alvarowau.stockroomsandbox.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImplMysql implements ProductDAO {

    private final MysqlConnection mysql;

    public ProductDAOImplMysql(){
        mysql = new MysqlConnection();
    }

    @Override
    public Product save(Product entity) {
        try (Connection connection = mysql.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SqlQueriesMysql.PRODUCT_INSERT, Statement.RETURN_GENERATED_KEYS);
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
        try (Connection connection = mysql.getDatabaseConnection()) {
            PreparedStatement statement = connection.prepareStatement(SqlQueriesMysql.PRODUCT_UPDATE);
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
        try (Connection connection = mysql.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueriesMysql.PRODUCT_DELETE);
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

        try (Connection connection = mysql.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueriesMysql.PRODUCT_SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product = createProductFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = mysql.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueriesMysql.PRODUCT_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = createProductFromResultSet(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return products;
    }

    private Product createProductFromResultSet(ResultSet set) throws SQLException {
        return new Product(
                set.getInt("idProduct"),
                set.getString("code"),
                set.getString("name"),
                set.getString("description"),
                set.getInt("stock"),
                set.getBoolean("status"),
                set.getDouble("price")
        );
    }

    private void handleSQLException(SQLException e) {
        System.out.println("Error Code: " + e.getErrorCode());
        System.out.println("Cause: " + e.getCause());
        System.out.println("Message: " + e.getMessage());
    }
}
