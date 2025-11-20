package Cvik8;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Uloha2 {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                try {
                    System.out.print("Zadajte cele cislo: ");
                    int number = readInteger(scanner);
                    System.out.println("Zadali ste cislo: " + number);
                    break;  // Ukoncime cyklus, ak je vstup platny
                } catch (InputMismatchException e) {
                    System.out.println("Chyba: Nenasiel sa platny vstup, skuste to znovu.");
                    scanner.next(); // Zbavime sa neplatneho vstupu
                } catch (NumberFormatException e) {
                    System.out.println("Chyba: Nespravny format cisla, skuste to znovu.");
                }
            }
    
            scanner.close();
        }
    
        // Metoda na citanie celeho cisla zo vstupu
        public static int readInteger(Scanner scanner) {
            String input = scanner.nextLine();
            return Integer.parseInt(input);  // Prevod na cele cislo
        }
    }

