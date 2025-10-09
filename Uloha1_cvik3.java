public class Uloha1_cvik3 {

	public static void primeNumber(int number) {
		if (number <= 1) {
			System.out.println(false);
			return;
		}

		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				System.out.println(false);
				return;
			}
		}

		System.out.println(true);
	}

	public static void factorial(int number) {
		if (number < 0) {
			System.out.println("Invalid input");
			return;
		}

		long result = 1;
		for (int i = 1; i <= number; i++) {
			result *= i;
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		// Здесь задаём числа, с которыми хотим работать
		primeNumber(2);
		factorial(5);
	}
}
