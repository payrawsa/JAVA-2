import java.util.InputMismatchException;

import java.util.Scanner;

public class excercise1 {

	private static double cofA = 1;

	private static double cofB = 1;

	private static double cofC = 1;

	public static void main(String[] args) {

		System.out.println("Usage: Supply 2 integers values as triangle sides.");

		System.out.println("      A - leading term (double value)");

		System.out.println("      B - second term (double value)");

		System.out.println("      C - constant term (double value)");

		System.out.println("      Q - quit the program");

		Scanner scForVal = new Scanner(System.in);

		Scanner scForSid = new Scanner(System.in);

		String side;

		Double value;
		
		int check;
		
		Double x1 = 0.0;

		Double x2 = 0.0;

		boolean carryOn = true;

		System.out.println("input these commands first \"A,B,C or Q\"");

		while (carryOn)

		{

			System.out.println("\ncurrent status y= " + cofA + "x^2 + " + cofB + "x + " + cofC);

			if (x1 == x2) {

				System.out.println("solution is " + x1);

			} else {

				System.out.println("solutions are " + x1 + ", " + x2);

			}

			System.out.println("input these commands \"A,B,C or Q\"");

			System.out.println();

			side = scForSid.nextLine().toLowerCase();

			switch (side)

			{

			case "q":

				carryOn = false;

				break;

			case "a":

				try {

					value = scForVal.nextDouble();

					cofA = value;
					if (value==0){
						throw new InputMismatchException();
					}

					while ((Math.pow(cofB, 2) - 4 * cofA * cofC) < 0) {

						System.out.println("solotion is going to be NaN, retype A value");

						value = scForVal.nextDouble();
					}
					
						cofA = value;
						
						
						scForVal = new Scanner(System.in);
						
					break;

				}

				catch (InputMismatchException ex) {

					System.out.println("you should input a                                                                                                                                          double not equal to 0");

					break;

				}

			case "b":

				try {

					value = scForVal.nextDouble();

					cofB = value;

					while ((Math.pow(cofB, 2) - 4 * cofA * cofC) < 0) {

						System.out.println("solotion is going to be NaN, retype B value");

						value = scForVal.nextDouble();

						cofB = value;

					}

					scForVal = new Scanner(System.in);
					
					break;

				}

				catch (InputMismatchException ex) {

					System.out.println("you should input only double");

					break;

				}

			case "c":

				try {

					value = scForVal.nextDouble();

					cofC = value;

					while ((Math.pow(cofB, 2) - 4 * cofA * cofC) < 0) {

						System.out.println("solotion is going to be NaN, retype C value");

						value = scForVal.nextDouble();

						cofC = value;

					}

					scForVal = new Scanner(System.in);
					
					break;

				}

				catch (InputMismatchException ex) {

					System.out.println("you should input only double");

					break;

				}


			default:

				System.out.println("Incorrect input");

				break;

			}

			x1 = (-cofB + Math.sqrt(Math.pow(cofB, 2) - 4 * cofA * cofC)) / 2 * cofA;

			x2 = (-cofB - Math.sqrt(Math.pow(cofB, 2) - 4 * cofA * cofC)) / 2 * cofA;

		}

		System.out.println("Thank you! Good bye!");

		return;

	}

}