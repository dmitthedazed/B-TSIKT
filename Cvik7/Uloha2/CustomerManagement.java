package Cvik7.Uloha2;

import java.util.LinkedList;

public class CustomerManagement {
    private LinkedList<Customer> customers;

    // Конструктор
    public CustomerManagement() {
        this.customers = new LinkedList<>();
    }

    // Метод для додавання нового клієнта
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Метод для пошуку клієнта за електронною поштою
    public Customer findCustomerByEmail(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;  // Якщо клієнт не знайдений
    }

    // Метод для виведення всіх клієнтів
    public void displayAllCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
