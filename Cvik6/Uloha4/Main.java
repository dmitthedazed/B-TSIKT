package Cvik6.Uloha4;
public class Main {
    public static void main(String[] args) {
        // Vytvorenie auta na benzin
        DopravneProstriedok auto = new Auto("Toyota Camry", TypPaliva.BENZIN);
        auto.start();
        auto.natankuj(TypPaliva.ELEKTRIKA);
        auto.stop();

        System.out.println();

        // Vytvorenie elektrickeho auta
        DopravneProstriedok elektrickeAuto = new ElektrickeAuto("Tesla Model 3");
        elektrickeAuto.start();
        elektrickeAuto.natankuj(TypPaliva.ELEKTRIKA);
        elektrickeAuto.stop();
        
        System.out.println();

        // Skusime natankovat elektricke auto benzinom
        elektrickeAuto.natankuj(TypPaliva.ELEKTRIKA);
    }
}
