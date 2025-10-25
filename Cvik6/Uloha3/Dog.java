package Cvik6.Uloha3;

public class Dog implements Animal {
    private String name;  // Атрибут для имени

    // Конструктор для создания объекта с именем
    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;  // Возвращаем имя
    }

    @Override
    public void speak() {
        System.out.println(name + " hovori: Haf-haf!");  // Шум, который издает собака
    }

    @Override
    public void move() {
        System.out.println(name + " beha.");  // Действие для собаки
    }
}
