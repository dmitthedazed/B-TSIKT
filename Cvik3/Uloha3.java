package Cvik3;
import java.text.DecimalFormat;

public class Uloha3 {
	private static final DecimalFormat FORMAT = new DecimalFormat("0.##########");

	public static void calculator(double first, double second) {
		String sum = FORMAT.format(first + second);
		String difference = FORMAT.format(first - second);
		String product = FORMAT.format(first * second);
		String quotient = second != 0 ? FORMAT.format(first / second) : "undefined";

		System.out.println(sum + ", " + difference + ", " + product + ", " + quotient);
	}

	public static void main(String[] args) {
		calculator(1, 1);
	}
}
