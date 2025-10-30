package Cvik7.Uloha2;

public class Uloha2 {
    public static void main(String[] args) {
        // Створення об'єктів Customer
        Customer customer1 = new Customer("Jan", "Novak", "jan.novak@example.com", "0912345678");
        Customer customer2 = new Customer("Eva", "Kovac", "eva.kovac@example.com", "0987654321");
        Customer customer3 = new Customer("Marek", "Horvath", "marek.horvath@example.com", "0956781234");

        // Створення об'єкта CustomerManagement
        CustomerManagement management = new CustomerManagement();

        // Додавання клієнтів у список
        management.addCustomer(customer1);
        management.addCustomer(customer2);
        management.addCustomer(customer3);

        // Пошук клієнта за електронною поштою
        Customer foundCustomer = management.findCustomerByEmail("eva.kovac@example.com");
        if (foundCustomer != null) {
            System.out.println("Found customer: " + foundCustomer);
        } else {
            System.out.println("Customer not found.");
        }

        // Виведення всіх клієнтів
        management.displayAllCustomers();
    }
}
