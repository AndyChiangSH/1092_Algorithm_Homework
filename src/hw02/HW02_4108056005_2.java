// positive and negative case: O(N^2*logN)
package hw02;

public class HW02_4108056005_2 extends ThreeSum {
	
	boolean hasZero=false;
	
	public static void main(String[] args) {
		
		HW02_4108056005_2 test = new HW02_4108056005_2();
		RandomArray ra = new RandomArray();
		int[] A = ra.createArray(10000, 10000);
//		int[] A = {-999, -995, -990, -989, -984, -982, -981, -980, -979, -975, -973, -970, -967, -965, -964, -963, -962, -958, -955, -953, -951, -950, -948, -947, -946, -945, -942, -940, -938, -936, -934, -931, -930, -929, -927, -926, -925, -923, -920, -916, -915, -914, -913, -912, -910, -908, -906, -904, -903, -902, -899, -898, -896, -895, -893, -888, -887, -886, -885, -883, -882, -877, -876, -873, -872, -871, -870, -869, -865, -864, -862, -860, -858, -856, -853, -852, -850, -848, -842, -840, -837, -834, -831, -829, -828, -827, -826, -823, -821, -820, -818, -815, -814, -811, -810, -809, -808, -807, -805, -804, -802, -799, -798, -794, -793, -792, -791, -790, -789, -788, -787, -781, -779, -777, -776, -774, -773, -771, -769, -768, -767, -764, -762, -761, -760, -759, -757, -753, -752, -751, -748, -747, -746, -744, -743, -742, -741, -740, -738, -737, -731, -730, -726, -725, -724, -721, -719, -718, -717, -716, -715, -708, -703, -700, -698, -697, -693, -691, -690, -685, -684, -682, -681, -680, -679, -677, -676, -675, -673, -672, -671, -669, -666, -665, -663, -658, -656, -652, -651, -650, -648, -647, -646, -644, -643, -641, -640, -637, -636, -635, -634, -633, -632, -628, -626, -622, -621, -617, -615, -612, -611, -608, -607, -606, -602, -600, -596, -595, -594, -593, -592, -590, -586, -584, -583, -581, -579, -577, -576, -574, -572, -570, -569, -567, -566, -564, -563, -562, -561, -558, -557, -556, -553, -552, -549, -544, -543, -542, -539, -537, -536, -535, -534, -533, -530, -526, -523, -522, -519, -518, -517, -514, -511, -510, -504, -503, -502, -501, -497, -495, -492, -490, -489, -487, -486, -480, -479, -478, -477, -476, -473, -472, -471, -470, -469, -467, -466, -465, -464, -463, -461, -459, -458, -457, -456, -455, -452, -451, -450, -445, -444, -441, -440, -433, -432, -431, -429, -428, -426, -425, -423, -422, -419, -418, -416, -415, -414, -412, -411, -410, -408, -405, -401, -396, -395, -393, -392, -391, -390, -388, -387, -386, -385, -384, -383, -381, -379, -376, -375, -374, -373, -371, -370, -366, -365, -364, -359, -358, -356, -354, -350, -349, -346, -345, -344, -342, -340, -338, -337, -336, -334, -333, -332, -331, -329, -325, -322, -318, -316, -315, -311, -306, -303, -302, -300, -299, -298, -297, -295, -293, -292, -290, -288, -287, -286, -285, -282, -280, -279, -277, -276, -275, -273, -272, -271, -266, -262, -261, -259, -258, -256, -254, -252, -251, -250, -248, -247, -246, -245, -244, -243, -241, -238, -236, -229, -227, -226, -225, -224, -221, -220, -219, -218, -216, -215, -214, -213, -212, -211, -209, -207, -205, -204, -203, -201, -197, -196, -192, -189, -184, -182, -180, -178, -177, -176, -174, -168, -167, -166, -164, -163, -160, -159, -158, -157, -155, -154, -148, -147, -146, -145, -143, -141, -136, -135, -134, -133, -131, -130, -127, -125, -124, -122, -115, -114, -109, -108, -105, -95, -93, -92, -91, -90, -87, -86, -84, -83, -82, -81, -79, -78, -76, -75, -72, -70, -68, -67, -64, -61, -60, -58, -55, -52, -51, -48, -45, -44, -38, -37, -36, -34, -33, -30, -29, -28, -27, -25, -23, -22, -19, -18, -17, -15, -13, -10, -9, -8, -7, -5, -4, -1, 4, 5, 6, 7, 9, 10, 13, 14, 15, 21, 23, 24, 26, 27, 30, 33, 34, 42, 46, 49, 51, 55, 57, 58, 62, 63, 64, 69, 71, 73, 75, 76, 77, 79, 80, 83, 84, 88, 89, 90, 92, 93, 94, 95, 98, 102, 104, 108, 111, 112, 113, 114, 116, 117, 118, 121, 122, 123, 125, 126, 130, 133, 134, 135, 139, 148, 155, 156, 157, 158, 159, 160, 161, 162, 164, 165, 173, 176, 178, 181, 183, 187, 188, 191, 193, 196, 197, 199, 201, 203, 204, 206, 207, 208, 210, 212, 216, 217, 219, 221, 222, 223, 224, 226, 228, 229, 233, 234, 235, 236, 237, 238, 239, 240, 241, 243, 245, 246, 248, 251, 257, 260, 261, 262, 264, 265, 266, 267, 273, 274, 275, 276, 277, 284, 287, 288, 289, 292, 297, 298, 299, 300, 302, 303, 304, 306, 307, 309, 310, 311, 313, 316, 321, 323, 325, 328, 329, 332, 333, 336, 337, 339, 340, 341, 343, 345, 347, 350, 351, 353, 356, 357, 361, 363, 365, 366, 368, 370, 373, 375, 376, 379, 380, 381, 382, 383, 384, 385, 386, 388, 390, 391, 395, 396, 400, 405, 406, 407, 408, 409, 410, 412, 413, 415, 417, 418, 420, 423, 426, 427, 428, 430, 431, 434, 438, 441, 444, 446, 447, 448, 451, 454, 455, 456, 459, 460, 461, 463, 464, 465, 468, 469, 471, 472, 473, 479, 483, 487, 488, 489, 490, 492, 493, 494, 499, 508, 509, 512, 514, 517, 519, 521, 523, 525, 528, 529, 530, 534, 537, 538, 541, 542, 544, 545, 547, 548, 551, 552, 553, 554, 558, 559, 561, 566, 571, 572, 573, 579, 580, 581, 582, 583, 584, 590, 591, 594, 598, 599, 600, 601, 604, 606, 608, 609, 610, 611, 613, 618, 619, 624, 631, 632, 634, 635, 637, 642, 643, 649, 654, 656, 657, 659, 660, 661, 663, 664, 665, 668, 670, 671, 673, 674, 676, 678, 680, 684, 686, 687, 689, 691, 695, 696, 697, 699, 701, 703, 704, 706, 707, 711, 713, 714, 718, 723, 725, 729, 730, 731, 738, 739, 740, 742, 743, 744, 746, 748, 750, 752, 753, 755, 756, 759, 760, 764, 767, 769, 770, 773, 774, 776, 777, 780, 785, 786, 787, 790, 791, 793, 794, 795, 796, 798, 800, 801, 802, 803, 804, 806, 808, 819, 821, 822, 823, 824, 827, 828, 831, 833, 834, 838, 840, 841, 843, 847, 848, 849, 851, 852, 854, 856, 858, 859, 862, 866, 870, 872, 873, 874, 875, 876, 877, 881, 882, 885, 893, 894, 895, 896, 897, 898, 902, 903, 908, 915, 918, 923, 924, 925, 926, 931, 934, 935, 937, 940, 942, 943, 944, 945, 949, 950, 952, 955, 957, 958, 959, 960, 961, 962, 963, 964, 966, 968, 969, 970, 971, 972, 975, 980, 983, 984, 986, 987, 989, 990, 991, 994, 995, 997, 998};
		Stopwatch stopwatch = new Stopwatch();
		System.out.println("ThreeSum is zero: "+test.T_sum(A));
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}
	
	@Override
	// O(N^2*logN)
	public int T_sum(int[] A) {
		int count = 0;
		this.quickSort(A, 0, A.length-1);	// quickSort: O(NlogN)
//		this.show(A);
		
		// find the index of min positive: O(1)
		int minPosIndex=0;
		for(int i=0; i<A.length; i++) {
			int index = this.rank(A, i, 0, A.length-1);
			if(index != -1) {
				if(i == 0) {
					hasZero = true;
				}
				minPosIndex = index;
				break;
			}
		}
		
		// find stast position of positive numbers: O(1)
		int posStart = 0;
		if(hasZero) {
			posStart = minPosIndex+1;
		}
		else {
			posStart = minPosIndex;
		}
//		System.out.println("minPosIndex = "+minPosIndex);
		
		// sum of three numbers is zero: O((N^2)/4*log(N/2))
		for(int i=0; i<minPosIndex; i++) {
			for(int j=posStart; j<A.length; j++) {
				if(-(A[i]+A[j]) > 0) {
					if(this.rank(A, -(A[i]+A[j]), j+1, A.length-1) != -1) {
						count++;
//						System.out.println(A[i]+", "+A[j]+", "+(-(A[i]+A[j])));
					}
					
				}
				else if(-(A[i]+A[j]) < 0) {
					if(this.rank(A, -(A[i]+A[j]), i+1, minPosIndex-1) != -1) {
						count++;
//						System.out.println(A[i]+", "+A[j]+", "+(-(A[i]+A[j])));
					}
				}
				else {
					if(hasZero) {
						count++;
//						System.out.println(A[i]+", "+A[j]+", "+(-(A[i]+A[j])));
					}
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
	
	public int rank(int[] A, int key, int l, int h) {
		int low = l, high = h;
		while(low <= high) {
			int mid = low+(high-low)/2;
			if(key < A[mid]) high = mid-1;
			else if(key > A[mid]) low = mid+1;
			else return mid;
		}
		return -1;
	}
	
	public void quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);

	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	private int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
}

