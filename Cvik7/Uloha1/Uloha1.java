package Cvik7.Uloha1;

import java.util.ArrayList;
import java.util.Collections;

public class Uloha1 {
    public static void main(String[] args) {
        // Створення об'єктів Zamestnanec
        Zamestnanec zam1 = new Zamestnanec("Jan", "Novak", 30);
        Zamestnanec zam2 = new Zamestnanec("Eva", "Kovac", 25);
        Zamestnanec zam3 = new Zamestnanec("Marek", "Horvath", 40);

        // Створення ArrayList і додавання об'єктів
        ArrayList<Zamestnanec> zamestnanci = new ArrayList<>();
        zamestnanci.add(zam1);
        zamestnanci.add(zam2);
        zamestnanci.add(zam3);

        // Додавання ще двох об'єктів за допомогою Collections.addAll
        Zamestnanec zam4 = new Zamestnanec("Peter", "Barta", 35);
        Zamestnanec zam5 = new Zamestnanec("Lukas", "Kollar", 28);
        Collections.addAll(zamestnanci, zam4, zam5);

        // Виведення всіх співробітників
        for (Zamestnanec zamestnanec : zamestnanci) {
            System.out.println(zamestnanec);
        }
    }
}
