package Cvik4.Uloha1;

//VelkePismena (все большие)
import java.util.Scanner;

public class Uloha1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadaj reťazec: ");
        String vstup = sc.nextLine();  //Считываем введённый текст (и пробелы) и сохраняем в переменной vstup

        String vysledok = vstup.toUpperCase();   //преобразует все буквы в строке в заглавные

        System.out.println("Reťazec veľkými písmenami: " + vysledok);

        sc.close();
        }
    }