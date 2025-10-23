package Cvik5.Uloha1_2;


public class Animal {
    // Atribúty (členské premenné)
    private String name;
    private int age;

    // Konštruktor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Vytvorené zviera: " + this.name);
    }

    // Metóda na zobrazenie základných informácií
    public String displayInfo() {
        return "Meno: " + name + ", Vek: " + age + " rokov.";
    }

    // Metóda na vydanie zvuku
    public String makeSound() {
        return "Zviera vydáva zvuk.";
    }

    // (Voliteľné) Gettery pre prístup k privátnym atribútom
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

