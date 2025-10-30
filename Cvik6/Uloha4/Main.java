package Cvik6.Uloha4;
public class Main {
    public static void main(String[] args) {
        //auto na benzin
        DopravneProstriedok auto = new Auto("Toyota Camry", TypPaliva.BENZIN);
        auto.start();
        auto.natankuj(TypPaliva.ELEKTRIKA);
        auto.stop();

        System.out.println();

        //auto na elektriku
        DopravneProstriedok elektrickeAuto = new ElektrickeAuto("Tesla Model 3", TypPaliva.ELEKTRIKA);
        elektrickeAuto.start();
        elektrickeAuto.natankuj(TypPaliva.ELEKTRIKA);
        elektrickeAuto.stop();
        
        System.out.println();
    }
}
