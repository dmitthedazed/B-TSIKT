public class Uloha2_cvik3 {

	public static void sumAll(int number) {
		if (number <= 0) {
			System.out.println(0);
			return;
		}

		int sum = 0;
		for (int i = 0; i < number; i++) {
			sum += i;
		}

		System.out.println(sum);
	}

	public static void main(String[] args) {
		sumAll(5);
		sumAll(4);
		sumAll(3);
		sumAll(2);
		sumAll(1);
	}
}
