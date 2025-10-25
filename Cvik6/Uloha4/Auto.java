package Cvik6.Uloha4;

public class Auto implements DopravneProstriedok {
    private String model;
    private TypPaliva palivo;

    // Конструктор
    public Auto(String model, TypPaliva palivo) {
        this.model = model;
        this.palivo = palivo;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void start() {
        System.out.println(model + " s typom paliva " + palivo + " bol nastartovany.");
    }

    @Override
    public void stop() {
        System.out.println(model + " sa zastavil.");
    }

    @Override
    public void natankuj(TypPaliva palivo) {
        if (this.palivo == palivo) {
            System.out.println("Natankovane " + model + " palivom: " + palivo);
        } else {
            System.out.println("Toto auto nepodporuje take palivo.");
        }
    }
}

