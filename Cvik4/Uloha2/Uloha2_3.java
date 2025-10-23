package Cvik4.Uloha2;
//RozdelenieRetazca (Разделение строки на слова)

import java.util.Scanner;
public class Uloha2_3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Zadaj text: ");
            String text = sc.nextLine();

            String[] slova = text.split(" ");

            System.out.println("Slová v texte:");
            for (int i = 0; i < slova.length; i++) {
                System.out.println(slova[i]);
            }
        }
    }
}
