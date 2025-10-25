package Cvik5.Uloha3;

public class Main {

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        System.out.println("Plocha kola: " + circle.getArea());
        System.out.println("Plocha ouholnika: " + rectangle.getArea());
    }
}

