package Cvik6.Uloha3;

public class Cat implements Animal {
    private String name;  // Атрибут для имени

    // Конструктор для создания объекта с именем
    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;  // Возвращаем имя
    }

    @Override
    public void speak() {
        System.out.println(name + " hovori: Mnau!");  // Шум, который издает кошка
    }

    @Override
    public void move() {
        System.out.println(name + " chodi.");  // Действие для кошки
    }
}
