package Cvik5.Uloha2;

//RemoveSpacesDemo (убирает все пробелы)
import java.util.Scanner;

public class Uloha2_2 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadaj text: ");
        String text = sc.nextLine();

        String bezMedzier = text.replace(" ", "");

        System.out.println("Bez medzier: " + bezMedzier);
    }
}
