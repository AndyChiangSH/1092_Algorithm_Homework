// case5_kashiwa is god
package hw02;

public class HW02_4108056005_5 extends ThreeSum{
    static int threadNum = 8;
    static int log_2_threadNum = 3;
    volatile static int _count;
    
    public static void main(String[] args) {
    	System.out.println("case5:");
    	HW02_4108056005_5 test = new HW02_4108056005_5();
    	int[] A = new RandomArray().readData();
		Stopwatch stopwatch = new Stopwatch();
		System.out.println("ThreeSum is zero: "+test.T_sum(A));
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}

    private static void merge_sort(int[] arr){
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

    public int T_sum(int[] A){
        merge_sort(A);
        int real_len = A.length;
        int len_for_start = binarySearchClosest(0, real_len-1, A, 0);

        if(len_for_start >= threadNum){
            Thread[] collaborate = new Thread[threadNum];
            _count = 0;
            for(int j=0; j<threadNum; j++){
                final int i = j;
                collaborate[i] = new Thread(new Runnable(){
                    public void run(){
                        int start, mid, end, sum, tmp, count=0;
                        for(start=(len_for_start*i) >> log_2_threadNum; start<(len_for_start*(i+1))>> log_2_threadNum; start++){
                            end = real_len-1;
                            tmp = binarySearchClosest(start+1, end-1, A, ~ (A[start] + A[end]) + 1);
                            mid = (tmp>0)? tmp : start+1;
                            while(end > mid){
                                sum = A[start] + A[mid];
                                if(sum > ~A[end]+1){
                                    end--;
                                }else if(sum < ~A[end]+1){
                                    mid++;
                                }else{
                                    count++;
                                    end--;
                                    mid++;
                                }
                            }
                        }
                        _count += count;
                    }
                });
                collaborate[i].start();
            }

            try{
                for(int i=0; i<threadNum; i++){
                    collaborate[i].join();
                }
            }catch(InterruptedException e){

            }
        }else{
            int start, mid, end, sum;
            _count = 0;
            for(start=0; start<len_for_start; start++){
                mid = start+1;
                end = real_len-1;
                while(end > mid){
                    sum = A[start] + A[mid] + A[end];
                    if(sum > 0){
                        end--;
                    }else if(sum < 0){
                        mid++;
                    }else{
                        _count++;
                        end--;
                    }
                }
            }

        }
        return _count;
    }

    static int binarySearchClosest(int start, int end, int array[], int target){
        if(target < array[start]) return -2;
        if(target > array[end]) return -1;
        if(target == array[start]) return start;
        int mid;
        while(start+1 < end){
            mid = (start+end) >> 1;
            if(array[mid] > target){
                end = mid;
            }else if(array[mid] < target){
                start = mid;
            }else{
                return mid;
            }
        }
        return end;
    }
}