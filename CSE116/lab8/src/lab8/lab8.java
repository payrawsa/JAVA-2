package lab8;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class lab8 {
	public static String joinvalues(ArrayList<String> values) {
		String answer = ""; // final answer stored here
		int size = values.size(); // total size of array

		int largestvalue = 0;
		for (int k = 0; k < size; k++) {
			if (largestvalue < values.get(k).length()) {
				largestvalue = values.get(k).length();
			}
		}
		int temp = 0;
		/*
		 * this loop accesses each value of the array list. It then takes those
		 * values and adds up every value one by one, updating a
		 * carry-over-value.
		 */
		int carry = 0;
		int value = 0;
		for (temp = 0; temp <= largestvalue + 2; temp++) {
			value = carry;
			carry = 0;

			for (int i = 0; i < size; i++) {
				try {
					if (temp < largestvalue - 1) {
						int valuetoadd = Integer.parseInt((values.get(i).substring(temp, temp + 1)));

						value = value + valuetoadd;
					} else {
						int valuetoadd = Integer.parseInt((values.get(i).substring(temp)));
						value = value + valuetoadd;
					}

				} catch (IndexOutOfBoundsException | NumberFormatException a) {
				}
			}

			while (value > 9) {
				value = value - 10;
				carry++;
			}
			answer = Integer.toString(value) + answer;

		}
		while (answer.charAt(0) == '0') {
			answer = answer.substring(1, answer.length());
		}
		return answer;
	}

	public static String addjoin(String[] one, String[] two, String sign1, String sign2) {
		String answer = ""; // final answer stored here
		int size1 = one.length; // total size of array
		int size2 = two.length;
		int size = 0;
		String sign3 = "";
		if (size1 > size2) {
			size = size1;
		} else {
			size = size2;
		}
		int largestvalue = size;
		int temp = 0;
		/*
		 * this loop accesses each value of the array list. It then takes those
		 * values and adds up every value one by one, updating a
		 * carry-over-value.
		 */
		int carry = 0;
		int value = 0;
		for (temp = 0; temp < largestvalue; temp++) {
			value = carry;
			carry = 0;
			if (sign1.equals("-") ^ sign2.equals("-")) {
				if (sign1.equals("-")) {
					try {
						if (temp < size1 - 1) {
							int valuetoadd = -Integer.parseInt((one[temp]));

							value = value + valuetoadd;
						} else {
							int valuetoadd = -Integer.parseInt((one[temp]));
							value = value + valuetoadd;
						}

					} catch (IndexOutOfBoundsException | NumberFormatException a) {
					}
					try {
						if (temp < size2 - 1) {
							int valuetoadd = Integer.parseInt((two[temp]));
							value = value + valuetoadd;

						} else {
							int valuetoadd = Integer.parseInt((two[temp]));
							value = value + valuetoadd;

						}
					} catch (IndexOutOfBoundsException | NumberFormatException a) {
					}
					if (value < 0 && value > -10) {
						sign3 = "-";
					} else if (value < -9) {
						while (value < -9) {
							value = value + 10;
							carry--;

						}
					} else {
						while (value > 9) {
							value = value - 10;
							carry++;
						}
					}
				} else {
					try {
						if (temp < size1 - 1) {
							int valuetoadd = Integer.parseInt((one[temp]));

							value = value + valuetoadd;
						} else {
							int valuetoadd = Integer.parseInt((one[temp]));
							value = value + valuetoadd;
						}

					} catch (IndexOutOfBoundsException | NumberFormatException a) {
					}
					try {
						if (temp < size2 - 1) {
							int valuetoadd = -Integer.parseInt((two[temp]));
							value = value + valuetoadd;

						} else {
							int valuetoadd = -Integer.parseInt((two[temp]));
							value = value + valuetoadd;

						}
					} catch (IndexOutOfBoundsException | NumberFormatException a) {
					}

					while (value > 9) {
						value = value - 10;
						carry++;
					}
				}

			} else {
				try {
					if (temp < size1 - 1) {
						int valuetoadd = Integer.parseInt((one[temp]));

						value = value + valuetoadd;
					} else {
						int valuetoadd = Integer.parseInt((one[temp]));
						value = value + valuetoadd;
					}

				} catch (IndexOutOfBoundsException | NumberFormatException a) {
				}
				try {
					if (temp < size2 - 1) {
						int valuetoadd = Integer.parseInt((two[temp]));
						value = value + valuetoadd;

					} else {
						int valuetoadd = Integer.parseInt((two[temp]));
						value = value + valuetoadd;

					}
				} catch (IndexOutOfBoundsException | NumberFormatException a) {
				}

				while (value > 9) {
					value = value - 10;
					carry++;
				}
			}
			answer = Integer.toString(value) + answer;

		}
		while (answer.charAt(0) == '0') {
			answer = answer.substring(1, answer.length());
		}
		return answer;
	}

	public static String multiply(String inputinteger, String command, String factor) {

		String[] factorarray = factorvalues(factor);
		String[] arrayvalues = inputintegervalues(inputinteger);
		ArrayList<String> values = new ArrayList<String>();
		int size1 = factorarray.length;
		int size2 = arrayvalues.length;
		int f = 0;
		int a = 0;
		while (f < size1) {
			a = 0;
			while (a < size2) {

				int holder = Integer.parseInt(arrayvalues[a]) * Integer.parseInt(factorarray[f]);
				String holders = Integer.toString(holder);
				int zeros = a + f;
				for (int i = 0; i < zeros; i++) {
					holders = holders + "0";

				}
				holders = new StringBuilder(holders).reverse().toString();
				values.add(holders);
				a++;
			}
			f++;
		}
		String answer = joinvalues(values);
		return answer;
	}

	public static String[] factorvalues(String factor) {
		int length = factor.length();
		String[] factorvalues = new String[length];
		for (int i = 0; i < length; i++) {
			factorvalues[i] = new Character(factor.charAt(i)).toString();
		}
		return factorvalues;
	}

	public static String[] inputintegervalues(String inputinteger) {

		int length = inputinteger.length();
		String[] arrayvalues = new String[length];
		for (int i = 0; i < length; i++) {
			arrayvalues[i] = new Character(inputinteger.charAt(i)).toString();
		}
		return arrayvalues;

	}

	public static String add(String inputinteger, String factor, String sign1, String sign2) {
		String[] factorarray = factorvalues(factor);
		String[] arrayvalues = inputintegervalues(inputinteger);
		String answer = addjoin(arrayvalues, factorarray, sign1, sign2);
		return answer;
	}

	public static void main(String[] args) {
		String answer = "";
		String one = JOptionPane.showInputDialog(null, "enter an integer");
		String sign1 = "";
		if (one.contains("-")) {
			one = one.substring(1);
			sign1 = "-";
		} else if (one.contains("+")) {
			one = one.substring(1);
		}
		one = new StringBuilder(one).reverse().toString();
		String two = JOptionPane
				.showInputDialog(null, "what would you like to do with this integer? Enter Multiply, Add, Exponentiate")
				.toLowerCase();
		String three = "";
		String four = "";
		if (two.equals("exponentiate")) {
			four = JOptionPane.showInputDialog(null, "what integer value do you want to use for the operation?");
			three = one;
		} else {
			three = JOptionPane.showInputDialog(null, "what integer value do you want to use for the operation?");
		}
		String sign2 = "";
		if (three.contains("-")) {
			three = three.substring(1);
			sign2 = "-";
		} else if (three.contains("+")) {
			three = three.substring(1);
		}
		three = new StringBuilder(three).reverse().toString();
		if (two.equals("multiply") == true) {
			if (one.equals("0") || three.equals("0")) {
				answer = "0";
			} else {
				answer = multiply(one, two, three);
			}
			if (sign1 == "-" ^ sign2 == "-") {
				answer = "-" + answer;
			}

		} else if (two.equals("exponentiate") == true) {
			if (four.equals("0") == true) {
				answer = "1";
			} else if (four.equals("1") == true) {
				answer = new StringBuilder(one).reverse().toString();
			} else {

				int i = 0;
				String holder = one;
				int max = Integer.parseInt(four);
				while (i < max - 1) {
					answer = multiply(holder, two, three);
					holder = answer;
					holder = new StringBuilder(holder).reverse().toString();
					i++;
					continue;
				}
			}
		} else {
			if (one.equals("0")) {
				answer = three;
				answer = new StringBuilder(answer).reverse().toString();
			} else if (three.equals("0")) {
				answer = one;
				answer = new StringBuilder(answer).reverse().toString();

			} else {
				answer = add(one, three, sign1, sign2);
			}
		}
		JOptionPane.showMessageDialog(null, answer);
	}

}
