package Cvik4.Uloha2;
// Palidrom
import java.util.Scanner;

public class Uloha2_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadaj text: ");
        String text = sc.nextLine();

        text = text.toLowerCase(); // чтобы не зависеть от величины буквы

        String opacne = ""; //пустую строку, в где будем записывать перевёрнутую строку.
        for (int i = text.length() - 1; i >= 0; i--) {  //индекс последнего символа. Цикл идёт с конца строки к началу
            opacne = opacne + text.charAt(i);   //строка в обратном порядке
        }

        if (text.equals(opacne)) {  //проверяет, совпадают ли строки полностью
            System.out.println("Reťazec je palindróm.");
        } else {
            System.out.println("Reťazec nie je palindróm.");
        }
    }
}
