public class Loop {
    public static void main(String[] args) {
        // Vypisuje cisla 1..100 kazdu sekundu
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1000 ms = 1 sekunda
            } catch (InterruptedException e) {
                // Ak je vlakno prerusene, vypiseme spravu a ukoncime
                System.err.println("Program preruseny: " + e.getMessage());
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Hotovo.");
    }
}
