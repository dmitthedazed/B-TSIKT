package Cvik2;

public class Uloha2 {

	public static void demonstrateControlFlow(int number) {
        // Проверяем знак числа и выводим соответствующее сообщение
		if (number == 0) {
			System.out.println("Číslo je nula.");
			return;
		} else if (number < 0) {
			System.out.println("Číslo je záporné.");
		} else {
			System.out.println("Číslo je kladné.");
		}

		int absolute = Math.abs(number);
		int digitCount = 0;
		int temp = absolute;
        // Подсчитываем количество цифр в модуле числа с помощью цикла while
    	while (temp > 0) {
			temp /= 10;
			digitCount++;
		}

		int digitSum = 0;
		String digits = Integer.toString(absolute);
		// Складываем все цифры числа с помощью цикла for
		for (int i = 0; i < digits.length(); i++) {
			digitSum += digits.charAt(i) - '0';
		}

		// Определяем остаток от деления на 3 через переключатель switch
		switch (absolute % 3) {
			case 0:
				System.out.println("Číslo je deliteľné tromi.");
				break;
			case 1:
				System.out.println("Zvyšok po delení tromi je 1.");
				break;
			default:
				System.out.println("Zvyšok po delení tromi je 2.");
				break;
		}

		int countdown = 3;
		// Запускаем обратный отсчет от 3 с использованием цикла do-while
		do {
			System.out.println("Ostáva " + countdown + " krok" + (countdown == 1 ? "" : "y"));
			countdown--;
		} while (countdown > 0);

		// Выводим статистику по количеству и сумме цифр
		System.out.println("Počet cifier: " + digitCount);
		System.out.println("Súčet cifier: " + digitSum);
	}

	public static void main(String[] args) {
		demonstrateControlFlow(-0);
	}
}
