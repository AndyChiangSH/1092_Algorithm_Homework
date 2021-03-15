// case3 - positive and negative + Thread: O(N^2*logN)
 package hw02;

public class HW02_4108056005_3 extends ThreeSum {
	
	
	public static void main(String[] args) {
		System.out.println("case3");
		HW02_4108056005_3 test3 = new HW02_4108056005_3();
		int[] A = new RandomArray().readData();
		Stopwatch stopwatch = new Stopwatch();
		System.out.println("ThreeSum is zero: "+test3.T_sum(A));
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}
	
	@Override
	// O(N^2*logN)
	public int T_sum(int[] A) {
		int count = 0;
		
		this.merge_sort(A);
//		this.show(A);
		
		int limit = this.binarySearch(A, 0, 0, A.length-1);
		
		for(int i = 0; i < limit; i++) {
			int left = i+1;
			int right = A.length-1;
			
			while(left < right) {
				int sum = A[i]+A[left]+A[right];
				if(sum > 0) {
					right--;
				}
				else if(sum < 0) {
					left++;
				}
				else {
					count++;
					right--;
					left++;
				}
			}
		}

		return count;
	}
	
	public void show(int[] A) {
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+", ");
		}
		System.out.println();
	}
	
	public int binarySearch(int[] A, int key, int l, int h) {
		if(key < A[l]) return -1;
		if(key > A[h]) return -1;
		if(key == A[l]) return -1;
		if(key == A[h]) return -1;
		int low = l, high = h;
		while(low+1 < high) {
			int mid = (low+high)/2;
			if(key < A[mid]) high = mid;
			else if(key > A[mid]) low = mid;
			else return mid;
		}
		return high;
	}
	
	private void merge_sort(int[] arr){
        int[] orderedArr = new int[arr.length];
        for(int i = 2; i < arr.length << 1; i = i << 1) {
            for(int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = (left + (i >> 1)) >= arr.length ? (arr.length - 1) : (left + (i >> 1));
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
    }
}