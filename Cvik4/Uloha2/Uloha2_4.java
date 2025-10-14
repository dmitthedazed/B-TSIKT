package Cvik4.Uloha2;
//ZamenZnak (Замена одного символа на другой)
import java.util.Scanner;

public class Uloha2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadaj text: ");
        String text = sc.nextLine();

        System.out.print("Zadaj znak, ktorý chceš zmeniť: ");
        char stary = sc.next().charAt(0);   //sc.next() читает одно слово (до пробела).charAt(0) берёт первый символ этого слова.

        System.out.print("Zadaj nový znak: ");
        char novy = sc.next().charAt(0);    //все теж саме просто з новим символом

        String vysledok = text.replace(stary, novy);    //replace(oldChar, newChar) проходит по всей строке и заменяет каждое вхождение старого символа на новый.

        System.out.println("Nový text: " + vysledok);
    }
}
