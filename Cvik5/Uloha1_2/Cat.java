package Cvik5.Uloha1_2;


public class Cat extends Animal {

    // Konštruktor
    public Cat(String name, int age) {
        // Volanie konštruktora rodičovskej triedy
        super(name, age);
        System.out.println("Konkrétny typ: Mačka");
    }

    // Prepísaná metóda z rodičovskej triedy
    public String displayInfo() {
        return super.displayInfo() + ". Je to mačka.";
    }

    // Špecifická metóda pre Cat
    public String meow() {
        return "Mňau!";
    }

    @Override
    public String makeSound() {
        return meow();
    }
}
