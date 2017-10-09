import java.util.InputMismatchException;

import java.util.Scanner;

public class exercise {

	private static int sideA = 0;

	private static int sideB = 0;

	public static void main(String[] args) {

		System.out.println("Usage: Supply 2 integers values as triangle sides.");

		System.out.println("      A - integer value");

		System.out.println("      B - integer value");

		System.out.println("      C - attempt a pythagorean calculation");

		System.out.println("      Q - quit the program");

		Scanner scForVal = new Scanner(System.in);

		Scanner scForSid = new Scanner(System.in);

		String side;

		Integer value;

		boolean carryOn = true;

		System.out.println("input these commands first \"A,B,C or Q\"");

		while (carryOn)

		{

			System.out.println("\ncurrent status A: " + sideA + ", B: " + sideB);

			System.out.println("input these commands \"A,B,C or Q\" ");

			side = scForSid.nextLine().toLowerCase();

			switch (side)

			{

			case "q":

				carryOn = false;

				break;

			case "a":

				try {

					value = scForVal.nextInt();

					sideA = value;

					
					break;

				}

				catch (InputMismatchException ex) {

					System.out.println("you should input only integer");

					break;

				}

			case "b":

				try {

					value = scForVal.nextInt();

					sideB = value;

					break;

				}

				catch (InputMismatchException ex) {

					System.out.println("you should input only integer");

					break;

				}

			case "c":

				try {

					if (sideA <= 0 || sideB <= 0) {

						throw new InputMismatchException();

					}

					double box = Math.sqrt(sideA * sideA + sideB * sideB);

					System.out.println("The hypotenuse value is " + box);

					break;

				}

				catch (InputMismatchException ex) {

					System.out.println("Both A and B should be more than 0.");

					break;

				}

			default:

				System.out.println("Incorrect input");

				break;

			}

		}

		System.out.println("Thank you! Good bye!");

		return;

	}

}