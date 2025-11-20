package Cvik8;

public class Uloha4 {
    // Vytvorenie triedy na konverziu teploty
    public static void main(String[] args) {
        try {
            double celsius = 25;
            double fahrenheit = convertTemperature(celsius, "CtoF");
            System.out.println(celsius + " stupnov Celsia je " + fahrenheit + " stupnov Fahrenheita.");

            fahrenheit = 77;
            celsius = convertTemperature(fahrenheit, "FtoC");
            System.out.println(fahrenheit + " stupnov Fahrenheita je " + celsius + " stupnov Celsia.");
            
            // Priklad neplatnej konverzie
            convertTemperature(celsius, "InvalidType");  // Tento riadok vyhodi vynimku
        } catch (IllegalArgumentException e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }

    // Metoda na konverziu teploty medzi Celsiami a Fahrenheitmi
    public static double convertTemperature(double temperature, String type) {
        if (type.equals("CtoF")) {
            return (temperature * 9/5) + 32;  // Konverzia z Celsia na Fahrenheit
        } else if (type.equals("FtoC")) {
            return (temperature - 32) * 5/9;  // Konverzia z Fahrenheit na Celsius
        } else {
            // Vyhodenie vynimky pri neplatnom type konverzie
            throw new IllegalArgumentException("Neplatny typ konverzie: " + type);
        }
    }
}