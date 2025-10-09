import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Zamestnanec {
    private String meno;
    private String pozicia;
    private int vek;
    private double mzda;
    private LocalDate datumNastupu;

    public Zamestnanec(String meno, String pozicia, int vek, double mzda, LocalDate datumNastupu) {
        this.meno = meno;
        this.pozicia = pozicia;
        this.vek = vek;
        this.mzda = mzda;
        this.datumNastupu = datumNastupu;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPozicia() {
        return pozicia;
    }

    public void setPozicia(String pozicia) {
        this.pozicia = pozicia;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public double getMzda() {
        return mzda;
    }

    public void setMzda(double mzda) {
        this.mzda = mzda;
    }

    public LocalDate getDatumNastupu() {
        return datumNastupu;
    }

    public void setDatumNastupu(LocalDate datumNastupu) {
        this.datumNastupu = datumNastupu;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Zamestnanec{" +
                "meno='" + meno + '\'' +
                ", pozicia='" + pozicia + '\'' +
                ", vek=" + vek +
                ", mzda=" + String.format("%.2f", mzda) +
                ", datumNastupu=" + datumNastupu.format(formatter) +
                '}';
    }
}
