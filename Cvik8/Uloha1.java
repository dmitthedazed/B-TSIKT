package Cvik8;

public class Uloha1 {
    // Metoda na delenie dvoch cisel s osetrenim vynimky delenia na nulu
    public static void main(String[] args) {
        try {
            System.out.println(divide(10, 0));  // Priklad delenia na nulu
        } catch (ArithmeticException e) {
            System.out.println("Chyba: Delenie na nulu!");
        }
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Nemozno delit na nulu");
        }
        return a / b;
    }
}
