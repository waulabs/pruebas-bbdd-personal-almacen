package org.alvarowau.stockroomsandbox.dao.mysql;

import org.alvarowau.stockroomsandbox.dao.SaleDAO;
import org.alvarowau.stockroomsandbox.models.Sale;

import java.util.List;

public class SaleDAOImplMysql implements SaleDAO {
    @Override
    public Sale save(Sale entity) {
        return null;
    }

    @Override
    public boolean update(Sale entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Sale findById(Integer integer) {
        return null;
    }

    @Override
    public List<Sale> findAll() {
        return List.of();
    }
}
