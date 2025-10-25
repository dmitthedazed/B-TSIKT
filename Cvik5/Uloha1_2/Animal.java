package Cvik5.Uloha1_2;


public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Vytvorené zviera: " + this.name);
    }

    public String displayInfo() {
        return "Meno: " + name + ", Vek: " + age + " rokov.";
    }

    public String makeSound() {
        return "Zviera vydáva zvuk.";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

