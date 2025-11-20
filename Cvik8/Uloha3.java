package Cvik8;

// Vytvorenie vlastnej vynimky pre kontrolu veku
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Uloha3 {

    public static void main(String[] args) {
        try {
            int age = 15;  // Priklad neplatneho veku
            checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }

    // Metoda na kontrolu veku
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18 || age > 100) {  // Vek musi byt medzi 18 a 100
            throw new InvalidAgeException("Vek je mimo povoleneho rozsahu (18-100).");
        }
        System.out.println("Vek je platny: " + age);
    }
}
