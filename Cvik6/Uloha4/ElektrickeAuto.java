package Cvik6.Uloha4;

public class ElektrickeAuto implements DopravneProstriedok {
    private String model;

    // Конструктор
    public ElektrickeAuto(String model) {
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void start() {
        System.out.println(model + " bol nastartovany (elektricky).");
    }

    @Override
    public void stop() {
        System.out.println(model + " sa zastavil.");
    }

    @Override
    public void natankuj(TypPaliva palivo) {
        if (palivo == TypPaliva.ELEKTRIKA) {
            System.out.println("Nabity " + model + " zo siete.");
        } else {
            System.out.println("Toto auto nepodporuje tankovanie takymto palivom.");
        }
    }
}
