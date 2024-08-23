package org.alvarowau.stockroomsandbox.dao.mysql.pruebas;

import org.alvarowau.stockroomsandbox.dao.mysql.CustomerDAOImplMysql;
import org.alvarowau.stockroomsandbox.models.Customer;

import java.util.List;

public class CustomerTest {

    private static void testFindAll(){
        CustomerDAOImplMysql mysql = new CustomerDAOImplMysql();
        List<Customer> customers = mysql.findAll();
        for (Customer a : customers){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        testFindAll();
    }
}
