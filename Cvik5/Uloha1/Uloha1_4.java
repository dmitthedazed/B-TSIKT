package Cvik5.Uloha1;

import java.util.Scanner;

public class Uloha1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadaj hlavný reťazec: ");
        String hlavny = sc.nextLine();      //ввести основную строку, B которой нужно искать.

        System.out.print("Zadaj podreťazec: ");
        String pod = sc.nextLine();         //ввести подстроку, которую нужно найти.

        int pozicia = hlavny.indexOf(pod);
            //ищет, где именно подстрока встречается в тексте.
        //Он возвращает:номер позиции (индекс), если нашёл, -1, если не нашёл. Индексация начинается с 0
        if (pozicia != -1) {
            System.out.println("Podreťazec sa zacina na indexe: " + pozicia);
        } else {
            System.out.println("Podreťazec sa nenašiel.");
        }

        sc.close();
    }
}
