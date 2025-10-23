package Cvik5.Uloha3;

public class Main {

    public static void main(String[] args) {
        // Створюємо об'єкти класів Circle і Rectangle
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        // Використовуємо поліморфізм для виклику методу getArea()
        System.out.println("Plocha kola: " + circle.getArea());
        System.out.println("Plocha ouholnika: " + rectangle.getArea());
    }
}

