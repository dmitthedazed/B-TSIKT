package Cvik6.Uloha3;

public class Bird implements Animal {
    private String name;  // Атрибут для имени

    // Конструктор для создания объекта с именем
    public Bird(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;  // Возвращаем имя
    }

    @Override
    public void speak() {
        System.out.println(name + " cirika.");  // Шум, который издает птица
    }

    @Override
    public void move() {
        System.out.println(name + " lieta.");  // Действие для птицы
    }
}