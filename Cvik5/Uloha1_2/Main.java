package Cvik5.Uloha1_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Pridať zviera");
            System.out.println("2. Zobraziť všetky zvieratá");
            System.out.println("3. Prehrať zvuk zvieraťa");
            System.out.println("4. Odstrániť zviera");
            System.out.println("5. Ukončiť");
            System.out.print("Vyberte možnosť: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Neplatný vstup. Zadajte číslo.");
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
                    System.out.println("Neplatná voľba. Skúste to znova.");
            }
        }
    }

    private static void addAnimal(Scanner scanner, ArrayList<Animal> animals) {
        System.out.println("--------------------");
        System.out.print("Aké zviera chcete pridať? (pes/mačka): ");
        String animalType = scanner.nextLine();

        if (!animalType.equalsIgnoreCase("pes") && !animalType.equalsIgnoreCase("macka")) {
            System.out.println("Len pes alebo mačka.");
            return;
        }

        System.out.print("Zadajte meno zvieraťa: ");
        String name = scanner.nextLine();

        System.out.print("Zadajte vek zvieraťa: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Neplatný vek. Zviera nebolo pridané.");
            return;
        }

        if (animalType.equalsIgnoreCase("pes")) {
            animals.add(new Dog(name, age));
            System.out.println("Pes pridaný.");
        } else {
            animals.add(new Cat(name, age));
            System.out.println("Mačka pridaná.");
        }
    }

    private static void viewAnimals(ArrayList<Animal> animals) {
        System.out.println("--------------------");
        System.out.println("Zoznam zvierat:");
        if (animals.isEmpty()) {
            System.out.println("Zoznam je prázdny.");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                System.out.println((i + 1) + ". " + animals.get(i).displayInfo());
            }
        }
    }

    private static void playAnimalSound(Scanner scanner, ArrayList<Animal> animals) {
        System.out.println("--------------------");
        if (animals.isEmpty()) {
            System.out.println("Niet žiadne zvieratá. Pridajte najprv zviera.");
            return;
        }

        viewAnimals(animals);
        System.out.print("Zadajte číslo zvieraťa, ktorého zvuk chcete prehrať: ");
        
        int index;
        try {
            index = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Neplatný vstup. Zadajte číslo.");
            return;
        }

        if (index >= 0 && index < animals.size()) {
            Animal animal = animals.get(index);
            System.out.println(animal.getName() + " vydáva zvuk: " + animal.makeSound());
        } else {
            System.out.println("Neplatné číslo. Zviera nenájdené.");
        }
    }

    private static void deleteAnimal(Scanner scanner, ArrayList<Animal> animals) {
        System.out.println("--------------------");
        if (animals.isEmpty()) {
            System.out.println("Niet čo odstrániť, zoznam je prázdny.");
            return;
        }

        viewAnimals(animals);
        System.out.print("Zadajte číslo zvieraťa, ktoré chcete odstrániť: ");
        
        int indexToRemove;
        try {
            indexToRemove = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Neplatný vstup. Zadajte číslo.");
            return;
        }

        if (indexToRemove >= 0 && indexToRemove < animals.size()) {
            Animal removedAnimal = animals.remove(indexToRemove);
            System.out.println("Zviera '" + removedAnimal.getName() + "' bolo odstránené.");
        } else {
            System.out.println("Neplatné číslo. Zviera nebolo odstránené.");
        }
    }
}
