package Cvik4.Uloha1;

import java.util.Scanner;

public class Uloha1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  //Scanner,считывает ввод с клавиатуры

        System.out.print("Zadaj prvý reťazec: ");
        String str1 = sc.nextLine();

        System.out.print("Zadaj druhý reťazec: ");
        String str2 = sc.nextLine();

        String vysledok = str1 + " " + str2;

        System.out.println("Zreťazený reťazec: " + vysledok);

        sc.close();
    }
}
