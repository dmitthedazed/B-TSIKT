package Cvik6;
public class Uloha1_2_Priklad {

    // Interface Vehicle
    public interface Vehicle {
        void start();      // Spustenie vozidla
        void stop();       // Zastavenie vozidla
        void accelerate(int speed);  // Zrýchlenie vozidla
        void brake(int speed);      // Spomalenie vozidla
    }

    // Class Car that implements Vehicle
    public static class Car implements Vehicle {
        private String type;
        private int speed;

        // Constructor
        public Car(String type) {
            this.type = type;
            this.speed = 0;
        }

        @Override
        public void start() {
            System.out.println(type + " auto sa spusta.");
        }

        @Override
        public void stop() {
            System.out.println(type + " auto sa zastavuje.");
        }

        @Override
        public void accelerate(int speed) {
            this.speed += speed;
            System.out.println(type + " auto zrychluje na " + this.speed + " mph.");
        }

        @Override
        public void brake(int speed) {
            this.speed -= speed;
            System.out.println(type + " auto spomaluje na " + this.speed + " mph.");
        }
    }

    // Class Bicycle that implements Vehicle (second task)
    public static class Bicycle implements Vehicle {
        private String type;
        private int speed;

        // Constructor
        public Bicycle(String type) {
            this.type = type;
            this.speed = 0;
        }

        @Override
        public void start() {
            System.out.println(type + " bicykel sa spusta.");
        }

        @Override
        public void stop() {
            System.out.println(type + " bicykel sa zastavuje.");
        }

        @Override
        public void accelerate(int speed) {
            this.speed += speed;
            System.out.println(type + " bicykel zrychluje na " + this.speed + " mph.");
        }

        @Override
        public void brake(int speed) {
            this.speed -= speed;
            System.out.println(type + " bicykel spomaluje na " + this.speed + " mph.");
        }
    }

    // Main method to test the Car and Bicycle classes
    public static void main(String[] args) {
        // Vytvorenie auta typu "Sedan"
        Vehicle sedan = new Car("Sedan");

        // Testovanie metód auta
        sedan.start();
        sedan.accelerate(30);
        sedan.accelerate(20);
        sedan.brake(10);
        sedan.stop();

        System.out.println();

        // Vytvorenie bicykla typu "Mountain" (druha úloha)
        Vehicle mountainBike = new Bicycle("Mountain");

        // Testovanie metód bicykla
        mountainBike.start();
        mountainBike.accelerate(10);
        mountainBike.accelerate(15);
        mountainBike.brake(5);
        mountainBike.stop();
    }
}
