package Cvik5.Uloha1_2;

public class Dog extends Animal {

    // Konštruktor
    public Dog(String name, int age) {
        // Volanie konštruktora rodičovskej triedy (MUSÍ BYŤ PRVÝ RIADOK!)
        super(name, age);
        System.out.println("Konkrétny typ: Pes");
    }

    // Prepísaná metóda z rodičovskej triedy (Polymorfizmus)
    @Override
    public String displayInfo() {
        // Použitie super.displayInfo() na získanie základných informácií z rodiča
        return super.displayInfo() + ". Je to pes.";
    }

    // Špecifická metóda pre Dog
    public String bark() {
        return "Haf! Haf!";
    }

    @Override
    public String makeSound() {
        return bark();
    }
}
    
