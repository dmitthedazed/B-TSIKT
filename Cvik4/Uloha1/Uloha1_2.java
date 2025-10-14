package Cvik4.Uloha1;
//Dĺžka reťazca (Длина строки)
import java.util.Scanner;

public class Uloha1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadaj reťazec: ");
        String text = sc.nextLine();

        System.out.println("Dĺžka reťazca je: " + text.length());  //метод, который возвращает количество символов в строке

        sc.close();
    }
}