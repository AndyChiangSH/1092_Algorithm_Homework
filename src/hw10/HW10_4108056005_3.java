// case3 - QuickSort: O(NlogN)
//package hw10;

public class HW10_4108056005_3 extends SortingArray {

	final static int CUTOFF = 32;

//	public static void main(String[] args) {
//		HW10_4108056005_3 test = new HW10_4108056005_3();
////		int[] input = { -2, 7, 15, -14, 0, 15, 0, 7, -7, -4, -13, 5, 8, -14, 12 };
////		int[] input = { -1, 2, 5, 9, 8, 7, 1, 3, 2 };
//		int[] input = { 1, 1, 1, 1, 2, 1, 1, 1, 1 };
////		int[] input = new TestDataGenerator().readData();
//
//		System.out.println("case3:");
//		System.out.println("Input array: ");
//		test.printArray(input, input.length);
//
//		Stopwatch stopwatch = new Stopwatch();
//		int[] ans = test.sorting(input);
//		double time = stopwatch.elapsedTime();
//		System.out.println("elapsed time " + time);
//
//		System.out.println("Sorted array: ");
//		test.printArray(ans, ans.length);
//	}

	@Override
	public int[] sorting(int[] A) {

		shuffle(A);
		quickSort(A);

		return A;
	}
	
	public void shuffle(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = (int) (Math.random() * (i));
			exch(a, i, r);
		}
	}

	private void quickSort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private void sort(int[] a, int lo, int hi) {
		// cutoff when the subarray is short
		if (hi - lo <= CUTOFF - 1) {
			insertion(a, lo, hi);
			return;
		}

		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi + 1;

		while (true) {
			while (a[++i] <= a[lo])
				if (i == hi)
					break;

			while (a[--j] > a[lo])
				if (j == lo)
					break;

			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	private void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void insertion(int[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			int temp = a[i];
			int j = i;
			while(j > lo && temp < a[j-1]) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
		}
	}

	public static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}
}
