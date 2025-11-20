package Cvik9;

import java.util.List;
import java.util.Scanner;

public class Uloha1 {
    
    public static void main(String[] args) {
        // Vytvorenie databázovej tabuľky
        DatabaseManager.createTable();
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\n=== SPRÁVA ŠTUDENTOV ===");
            System.out.println("1. Pridať nového študenta");
            System.out.println("2. Zobraziť všetkých študentov");
            System.out.println("3. Vyhľadať študenta podľa ID");
            System.out.println("4. Aktualizovať študenta");
            System.out.println("5. Vymazať študenta");
            System.out.println("0. Ukončiť");
            System.out.print("Vyberte možnosť: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Spotrebuj newline
            
            switch (choice) {
                case 1:
                    pridatStudenta(scanner);
                    break;
                case 2:
                    zobraziStudentov();
                    break;
                case 3:
                    vyhladatStudenta(scanner);
                    break;
                case 4:
                    aktualizovatStudenta(scanner);
                    break;
                case 5:
                    vymazatStudenta(scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Ukončujem program...");
                    break;
                default:
                    System.out.println("Neplatná voľba!");
            }
        }
        
        scanner.close();
    }
    
    private static void pridatStudenta(Scanner scanner) {
        System.out.print("Zadajte meno: ");
        String meno = scanner.nextLine();
        
        System.out.print("Zadajte priezvisko: ");
        String priezvisko = scanner.nextLine();
        
        System.out.print("Zadajte email: ");
        String email = scanner.nextLine();
        
        Student student = new Student(meno, priezvisko, email);
        DatabaseManager.insertStudent(student);
    }
    
    private static void zobraziStudentov() {
        List<Student> students = DatabaseManager.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("Žiadni študenti v databáze.");
        } else {
            System.out.println("\n=== ZOZNAM ŠTUDENTOV ===");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    
    private static void vyhladatStudenta(Scanner scanner) {
        System.out.print("Zadajte ID študenta: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Student student = DatabaseManager.getStudentById(id);
        if (student != null) {
            System.out.println("\nNájdený študent:");
            System.out.println(student);
        } else {
            System.out.println("Študent s ID " + id + " nebol nájdený.");
        }
    }
    
    private static void aktualizovatStudenta(Scanner scanner) {
        System.out.print("Zadajte ID študenta na aktualizáciu: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Student existujuci = DatabaseManager.getStudentById(id);
        if (existujuci == null) {
            System.out.println("Študent s ID " + id + " nebol nájdený.");
            return;
        }
        
        System.out.println("Aktuálne údaje: " + existujuci);
        
        System.out.print("Nové meno (Enter pre ponechanie): ");
        String meno = scanner.nextLine();
        if (!meno.isEmpty()) {
            existujuci.setMeno(meno);
        }
        
        System.out.print("Nové priezvisko (Enter pre ponechanie): ");
        String priezvisko = scanner.nextLine();
        if (!priezvisko.isEmpty()) {
            existujuci.setPriezvisko(priezvisko);
        }
        
        System.out.print("Nový email (Enter pre ponechanie): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            existujuci.setEmail(email);
        }
        
        DatabaseManager.updateStudent(existujuci);
    }
    
    private static void vymazatStudenta(Scanner scanner) {
        System.out.print("Zadajte ID študenta na vymazanie: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        DatabaseManager.deleteStudent(id);
    }
}
