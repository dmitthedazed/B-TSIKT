package Cvik6.Uloha3;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog(" Dima");
        Animal cat = new Cat(" Murka");
        Animal bird = new Bird(" Kesha");

        dog.speak();
        dog.move();

        cat.speak();
        cat.move();

        bird.speak();
        bird.move();
    }
}
