package Cvik7.Uloha2;

public class Customer {
    private String meno;
    private String priezvisko;
    private String email;
    private String telefonneCislo;

    // Конструктор для ініціалізації клієнта
    public Customer(String meno, String priezvisko, String email, String telefonneCislo) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.email = email;
        this.telefonneCislo = telefonneCislo;
    }

    // Геттери
    public String getMeno() {
        return meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefonneCislo() {
        return telefonneCislo;
    }

    // Метод для виведення інформації про клієнта
    @Override
    public String toString() {
        return "Customer: " + meno + " " + priezvisko + ", Email: " + email + ", Phone: " + telefonneCislo;
    }
}

