package Cvik4.Uloha3;

import java.util.Scanner;

// Класс сотрудника
class Employee {
    private String name;
    private int age;
    private double salary;
    private String position;

    // Конструктор
    public Employee(String name, int age, double salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    // Метод для вывода информации
    public void printInfo() {
        System.out.println("\nInformacia o zamestnancovi:");
        System.out.println("Meno: " + name);
        System.out.println("Vek: " + age);
        System.out.println("Pozícia: " + position);
        System.out.println("Platba: " + salary + " €");
    }
}

// Главный класс с меню
public class Uloha3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp = null;

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1. Vytvoriť zamestnanca");
            System.out.println("2. Zobraziť informácie");
            System.out.print("Vyberte možnosť: ");

            int choice = sc.nextInt();
            sc.nextLine(); // очистка буфера

            if (choice == 1) {
                System.out.print("Zadaj meno: ");
                String name = sc.nextLine();

                System.out.print("Zadaj vek: ");
                int age = sc.nextInt();

                System.out.print("Zadaj plat (v €): ");
                double salary = sc.nextDouble();
                sc.nextLine(); // очистка буфера

                System.out.print("Zadaj pozíciu: ");
                String position = sc.nextLine();

                emp = new Employee(name, age, salary, position);
                System.out.println("Zamestnanec bol úspešne vytvorený!");
            }

            if (choice == 2 && emp != null) {
                emp.printInfo();
            }
        }
    }
}
