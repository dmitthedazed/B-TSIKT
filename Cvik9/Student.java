package Cvik9;

public class Student {
    private int id;
    private String meno;
    private String priezvisko;
    private String email;

    // Konštruktor pre existujúceho študenta (s ID z databázy)
    public Student(int id, String meno, String priezvisko, String email) {
        this.id = id;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.email = email;
    }

    // Konštruktor pre nového študenta (bez ID)
    public Student(String meno, String priezvisko, String email) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.email = email;
    }

    // Gettery a settery
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Meno: %s | Priezvisko: %s | Email: %s", 
                            id, meno, priezvisko, email);
    }
}
