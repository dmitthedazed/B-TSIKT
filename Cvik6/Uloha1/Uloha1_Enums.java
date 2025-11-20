

import java.util.Scanner;

enum Season {
    Zima, Jar, Leto, Jesen;


    // получаем сезон по месяцу
    public static Season getSeason(int month) {
        switch (month) {
            case 12:
            case 1:
            case 2:
                return Zima;
            case 3:
            case 4:
            case 5:
                return Jar;
            case 6:
            case 7:
            case 8:
                return Leto;
            case 9:
            case 10:
            case 11:
                return Jesen;
            default:
                throw new IllegalArgumentException("Neplatny mesiac: " + month);
        }
    }
}

public class Uloha1_Enums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Zadajte cislo mesiaca (1-12): ");
        int month = scanner.nextInt();
        
        try {
            Season season = Season.getSeason(month);
            System.out.println("Rocne obdobie: " + season);
        } catch (IllegalArgumentException e) {
            System.out.println("Chyba: " + e.getMessage());
        }
        
        scanner.close();
    }
}
