import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Uloha3_cvik5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vytvorenie noveho zamestnanca");

		System.out.print("Zadajte meno: ");
		String meno = scanner.nextLine().trim();

		System.out.print("Zadajte poziciu: ");
		String pozicia = scanner.nextLine().trim();

		int vek = nacitajCeleCislo(scanner, "Zadajte vek: ");
		double mzda = nacitajDouble(scanner, "Zadajte mesacnu mzdu (EUR): ");
		LocalDate datumNastupu = nacitajDatum(scanner, "Zadajte datum nastupu (dd.MM.yyyy): ");

		Zamestnanec zamestnanec = new Zamestnanec(meno, pozicia, vek, mzda, datumNastupu);

		System.out.println("\nVytvoreny zamestnanec:");
		System.out.println(zamestnanec);
		scanner.close();
	}

	private static int nacitajCeleCislo(Scanner scanner, String vyzva) {
		while (true) {
			System.out.print(vyzva);
			String vstup = scanner.nextLine().trim();
			try {
				return Integer.parseInt(vstup);
			} catch (NumberFormatException e) {
				System.out.println("Prosím zadajte platné celé číslo.");
			}
		}
	}

	private static double nacitajDouble(Scanner scanner, String vyzva) {
		while (true) {
			System.out.print(vyzva);
			String vstup = scanner.nextLine().trim().replace(",", ".");
			try {
				return Double.parseDouble(vstup);
			} catch (NumberFormatException e) {
				System.out.println("Prosím zadajte platné číslo.");
			}
		}
	}

	private static LocalDate nacitajDatum(Scanner scanner, String vyzva) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		while (true) {
			System.out.print(vyzva);
			String vstup = scanner.nextLine().trim();
			try {
				return LocalDate.parse(vstup, formatter);
			} catch (DateTimeParseException e) {
				System.out.println("Prosím zadajte dátum v tvare dd.MM.yyyy.");
			}
		}
	}
}
