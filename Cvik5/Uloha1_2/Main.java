package Cvik5.Uloha1_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Pridat zviera");
            System.out.println("2. Zobrazit vsetky zvierata");
            System.out.println("3. Prehrat zvuk zvierata");
            System.out.println("4. Odstranit zviera");
            System.out.println("5. Ukoncit");
            System.out.print("Vyberte moznost: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Neplatny vstup. Zadajte cislo.");
                continue;
            }

            switch (choice) {
                case 1:
                    addAnimal(scanner, animals);
                    break;
                case 2:
                    viewAnimals(animals);
                    break;
                case 3:
                    playAnimalSound(scanner, animals);
                    break;
                case 4:
                    deleteAnimal(scanner, animals);
                    break;
                case 5:
                    System.out.println("Dovidenia!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Neplatna volba. Skuste to znova.");
            }
        }
    }

    private static void addAnimal(Scanner scanner, ArrayList<Animal> animals) {
        System.out.println("--------------------");
        
        String animalType;
        while (true) {
            System.out.print("Ake zviera chcete pridat? (pes/macka): ");
            animalType = scanner.nextLine();

            if (animalType.equalsIgnoreCase("pes") || animalType.equalsIgnoreCase("macka")) {
                break;
            }
            System.out.println("Len pes alebo macka. Skuste znova.");
        }

        System.out.print("Zadajte meno zvierata: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Zadajte vek zvierata: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Neplatny vek. Zadajte cislo.");
            }
        }

        if (animalType.equalsIgnoreCase("pes")) {
            animals.add(new Dog(name, age));
            System.out.println("Pes pridany.");
        } else {
            animals.add(new Cat(name, age));
            System.out.println("Macka pridana.");
        }
    }

    private static void viewAnimals(ArrayList<Animal> animals) {
        System.out.println("--------------------");
        System.out.println("Zoznam zvierat:");
        if (animals.isEmpty()) {
            System.out.println("Zoznam je prazdny.");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                System.out.println((i + 1) + ". " + animals.get(i).displayInfo());
            }
        }
    }

    private static void playAnimalSound(Scanner scanner, ArrayList<Animal> animals) {
        System.out.println("--------------------");
        if (animals.isEmpty()) {
            System.out.println("Niet ziadne zvierata. Pridajte najprv zviera.");
            return;
        }

        viewAnimals(animals);
        
        int index;
        while (true) {
            System.out.print("Zadajte cislo zvierata, ktoreho zvuk chcete prehrat: ");
            try {
                index = Integer.parseInt(scanner.nextLine()) - 1;
                
                if (index >= 0 && index < animals.size()) {
                    break;
                } else {
                    System.out.println("Neplatne cislo. Skuste znova.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatny vstup. Zadajte cislo.");
            }
        }

        Animal animal = animals.get(index);
        System.out.println(animal.getName() + " vydava zvuk: " + animal.makeSound());
    }

    private static void deleteAnimal(Scanner scanner, ArrayList<Animal> animals) {
        System.out.println("--------------------");
        if (animals.isEmpty()) {
            System.out.println("Niet co odstranit, zoznam je prazdny.");
            return;
        }

        viewAnimals(animals);
        
        int indexToRemove;
        while (true) {
            System.out.print("Zadajte cislo zvierata, ktore chcete odstranit: ");
            try {
                indexToRemove = Integer.parseInt(scanner.nextLine()) - 1;
                
                if (indexToRemove >= 0 && indexToRemove < animals.size()) {
                    break;
                } else {
                    System.out.println("Neplatne cislo. Skuste znova.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatny vstup. Zadajte cislo.");
            }
        }

        Animal removedAnimal = animals.remove(indexToRemove);
        System.out.println("Zviera '" + removedAnimal.getName() + "' bolo odstranene.");
    }
}
