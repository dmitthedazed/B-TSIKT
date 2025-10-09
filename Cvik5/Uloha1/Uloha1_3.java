package Cvik5.Uloha1;
//Porovnanie reťazcov (Сравнение строк)
import java.util.Scanner;

public class Uloha1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadaj prvý reťazec: ");
        String a = sc.nextLine();

        System.out.print("Zadaj druhý reťazec: ");
        String b = sc.nextLine();

        if (a.equals(b)) {           //.equals сравнивает содержание строк
            System.out.println("Reťazce sú rovnaké.");
        } else {
            System.out.println("Reťazce sa líšia.");
        }

        sc.close();
    }
}