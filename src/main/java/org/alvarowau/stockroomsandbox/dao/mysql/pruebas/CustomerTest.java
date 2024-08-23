package org.alvarowau.stockroomsandbox.dao.mysql.pruebas;

import org.alvarowau.stockroomsandbox.dao.mysql.CustomerDAOImplMysql;
import org.alvarowau.stockroomsandbox.models.AccountStatus;
import org.alvarowau.stockroomsandbox.models.Customer;
import org.alvarowau.stockroomsandbox.models.SubscriptionType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CustomerTest {

    private static CustomerDAOImplMysql customerDAO = new CustomerDAOImplMysql();
    private static Customer savedCustomer;

    private static void testFindAll() {
        List<Customer> customers = customerDAO.findAll();
        if (customers != null && !customers.isEmpty()) {
            System.out.println("All customers:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } else {
            System.out.println("No customers found.");
        }
    }

    private static void testCreate() {
        // Crear un objeto Customer con datos de ejemplo
        Customer customer = new Customer(
                "John",                       // firstName
                "Doe",                        // lastName
                "123456789",                  // numberPhone
                "johndoe@example.com",        // email
                "123 Main St",                // address
                LocalDate.of(1990, 1, 1),     // birthDate
                "Male",                       // gender
                "A123456789",                 // personalId
                "American",                   // nationality
                "johndoe",                    // userName
                "password123",                // password (será hasheada dentro del constructor)
                0,                            // loyaltyPoints (valor por defecto 0)
                AccountStatus.ACTIVE,         // accountStatus
                LocalDateTime.now(),          // lastLoginDate
                "Credit Card",                // preferredPaymentMethod
                SubscriptionType.BASIC,       // subscriptionType
                "123 Shipping Address",       // shippingAddress
                "123 Billing Address",        // billingAddress
                null                          // purchaseHistory (puede ser null o lista vacía)
        );

        // Guardar el objeto Customer en la base de datos
        savedCustomer = customerDAO.save(customer);

        // Verificar y mostrar el resultado
        if (savedCustomer != null) {
            System.out.println("Customer saved successfully: " + savedCustomer);
        } else {
            System.out.println("Failed to save the customer.");
        }
    }

    private static void testFindById() {
        if (savedCustomer != null) {
            Customer customer = customerDAO.findById(savedCustomer.getIdPerson());
            if (customer != null) {
                System.out.println("Customer found: " + customer);
            } else {
                System.out.println("No customer found with ID: " + savedCustomer.getIdPerson());
            }
        } else {
            System.out.println("Cannot find customer. No customer saved yet.");
        }
    }

    private static void testUpdate() {
        if (savedCustomer != null) {
            // Modificar algunos atributos del cliente
            savedCustomer.setAddress("456 New Address");
            savedCustomer.setEmail("john.doe@newdomain.com"); // Modificado para evitar duplicado
            savedCustomer.setLastLoginDate(LocalDateTime.now().plusDays(1)); // Actualiza la fecha de último inicio de sesión

            // Actualizar el cliente en la base de datos
            boolean isUpdated = customerDAO.update(savedCustomer);

            // Verificar el resultado de la actualización
            if (isUpdated) {
                System.out.println("Customer updated successfully: " + savedCustomer);
            } else {
                System.out.println("Failed to update the customer.");
            }
        } else {
            System.out.println("Cannot update customer. No customer saved yet.");
        }
    }

    private static void testDelete() {
        if (savedCustomer != null) {
            boolean isDeleted = customerDAO.delete(savedCustomer.getIdPerson());
            if (isDeleted) {
                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Failed to delete customer.");
            }
        } else {
            System.out.println("Cannot delete customer. No customer saved yet.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing create customer:");
        testCreate();

        System.out.println("\nTesting find all customers:");
        testFindAll();

        System.out.println("\nTesting find customer by ID:");
        testFindById();

        System.out.println("\nTesting update customer:");
        testUpdate();

        System.out.println("\nTesting delete customer:");
        testDelete();
    }
}
