package Cvik7.Uloha1;

public class Zamestnanec {
    private String meno;
    private String priezvisko;
    private int vek;

    // Конструктор
    public Zamestnanec(String meno, String priezvisko, int vek) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.vek = vek;
    }

    // Геттери для кожного атрибута
    public String getMeno() {
        return meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public int getVek() {
        return vek;
    }

    // Виведення інформації про співробітника
    @Override
    public String toString() {
        return "Zamestnanec: " + meno + " " + priezvisko + ", Vek: " + vek;
    }
}
