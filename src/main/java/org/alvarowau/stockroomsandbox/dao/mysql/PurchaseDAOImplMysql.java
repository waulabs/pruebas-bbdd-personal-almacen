package org.alvarowau.stockroomsandbox.dao.mysql;

import org.alvarowau.stockroomsandbox.dao.PurchaseDAO;
import org.alvarowau.stockroomsandbox.models.Purchase;

import java.util.List;

public class PurchaseDAOImplMysql implements PurchaseDAO {
    @Override
    public Purchase save(Purchase entity) {
        return null;
    }

    @Override
    public boolean update(Purchase entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Purchase findById(Integer integer) {
        return null;
    }

    @Override
    public List<Purchase> findAll() {
        return List.of();
    }
}
