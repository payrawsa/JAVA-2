public class Main {
	public static double[] array;

	public static void main(String[] args) {
		array = createlist();

		mergeSort(array);
		while (true) {
			for (int i = 0; i < 9999; i++) {

				if (array[i] < array[i + 1]) {
				} else {
					System.out.println("error");
					break;
				}
			}
			System.out.println("goodtogo");
			break;
		}
	}

	public static double[] createlist() {
		double[] list = new double[10000];
		for (int i = 0; i < 10000; i++) {
			list[i] = Math.random();
		}
		return list;
	}

	public static void mergeSort(double[] array) {
		if (array.length > 1) {
			double[] left = leftHalf(array);
			double[] right = rightHalf(array);
			mergeSort(left);
			mergeSort(right);
			merge(array, left, right);
		}
	}

	public static double[] leftHalf(double[] array) {
		int midpoint = array.length / 2;
		double[] left = new double[midpoint];
		for (int i = 0; i < midpoint; i++) {
			left[i] = array[i];
		}
		return left;
	}

	public static double[] rightHalf(double[] array) {
		int midpoint = array.length / 2;
		int arraysize = array.length - midpoint;
		double[] right = new double[arraysize];
		for (int i = 0; i < arraysize; i++) {
			right[i] = array[i + midpoint];
		}
		return right;
	}

	public static void merge(double[] result, double[] left, double[] right) {
		int leftindex = 0;
		int rightindex = 0;

		for (int i = 0; i < result.length; i++) {
			if (rightindex >= right.length || (leftindex < left.length && left[leftindex] <= right[rightindex])) {
				result[i] = left[leftindex];
				leftindex++;
			} else {
				result[i] = right[rightindex]; 
				rightindex++;
			}
		}
	}
}