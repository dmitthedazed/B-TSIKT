package Cvik6.Uloha4;

public interface DopravneProstriedok {
    String getModel();  // Получить модель транспортного средства
    void start();       // Запустить транспортное средство
    void stop();        // Остановить транспортное средство
    void natankuj(TypPaliva palivo);  // Заправить транспортное средство
}
