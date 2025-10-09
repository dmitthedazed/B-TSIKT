
  //1 Zreťazenie (Сцепление строк)
import java.util.Scanner;

public class Main {
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


/*   //Dĺžka reťazca (Длина строки)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadaj reťazec: ");
        String text = sc.nextLine();

        System.out.println("Dĺžka reťazca je: " + text.length());  //метод, который возвращает количество символов в строке

        sc.close();
    }
}
*/

/*   //Porovnanie reťazcov (Сравнение строк)
import java.util.Scanner;

public class Main {
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
*/

/*    //HladaniePodretazca (поиск подстроки)
import java.util.Scanner;

public class Main {
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
            System.out.println("Podreťazec sa nachádza na indexe: " + pozicia);
        } else {
            System.out.println("Podreťazec sa nenašiel.");
        }

        sc.close();
    }
}
*/

/*   //VelkePismena (все большие)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadaj reťazec: ");
        String vstup = sc.nextLine();  //Считываем введённый текст (и пробелы) и сохраняем в переменной vstup

        String vysledok = vstup.toUpperCase();   //преобразует все буквы в строке в заглавные

        System.out.println("Reťazec veľkými písmenami: " + vysledok);

        sc.close();
    }
}
*/

/*    //2 все маленькие
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadaj reťazec: ");
        String vstup = sc.nextLine();  //Считываем введённый текст (и пробелы) и сохраняем в переменной vstup

        String vysledok = vstup.toLowerCase();   //преобразует все буквы в строке в заглавные

        System.out.println("Reťazec veľkými písmenami: " + vysledok);

        sc.close();
    }
}
*/

/*   //RemoveSpacesDemo (убирает все пробелы)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadaj text: ");
        String text = sc.nextLine();

        String bezMedzier = text.replace(" ", "");

        System.out.println("Bez medzier: " + bezMedzier);
    }
}
*/

/*   //RozdelenieRetazca (Разделение строки на слова)
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadaj text: ");
        String text = sc.nextLine();

        String[] slova = text.split(" ");

        System.out.println("Slová v texte:");
        for (int i = 0; i < slova.length; i++) {
            System.out.println(slova[i]); }
    }
}
*/

/*  //ZamenZnak (Замена одного символа на другой)
import java.util.Scanner;

public class Main {
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
*/

/*  //Palidrom
import java.util.Scanner;

public class Main {
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
*/