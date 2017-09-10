package probs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * This Classes binarySearch method performs binary search on array of any size
 *  and return the index of the particular number. I've used recursion and passed the starting index
 *  and ending index of the array in each recursion as it is key to get the index of the target number in the main array that we've passed
 *  This may not be very effecient but please let me know if anyone can make this code better. 
 *  Thanks In Advance.
 */
public class BinarysearchAlgo {
	private static Integer targetIndex;

	public static void main(String[] arg) {

		Integer arr[] = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30 };
		Integer target = 13;
		Integer min = 0;
		Integer max = arr.length - 1;

		// since it works only on sorted array we sort arr here,
		// and this is the reason why we used Integer here instead of int.
		// To skip bothering about boxing and unboxing issues.
		ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(arr));
		Collections.sort(al);
		al.toArray(arr);
		// Finally the output from the binarySearch method is the raw index so
		// we add 1 to get the common index of the number.
		System.out.println(binarySearch(arr, target, min, max)+1 );
	}
/*
 * if the mid element is equal to the target then set targetIndex to the particular index 
 * else splits the given array into the left and right array then 
 * compare the mid element with target to choose 
 * if the recursion has to be performed with the left or right array 
 */
	public static Integer binarySearch(Integer[] ar, Integer target, Integer min, Integer max) {
		Integer mid = ar.length / 2;

		Integer[] left = new Integer[mid];
		Integer[] right = new Integer[ar.length - mid];

		for (Integer i = 0; i < left.length; i++)			left[i] = ar[i];
		for (Integer i = 0; i < right.length; i++)			right[i] = ar[mid++];
		mid = ar.length / 2;

		if (target == ar[mid]) {
			targetIndex = mid+min;
		}
		/*
		 *  if the target element is greater than the mid element recursion is
		 * done with the left array
		 */
		else if (target < ar[mid]) {
			if (left.length == 1) {
				if (left[0] == target) {
					targetIndex = min;
				} else {
					targetIndex = -1;
				}
			} else {
				max = (min + mid);
				binarySearch(left, target, min, max - 1);
			}
		}
		/* if the target element is lessr than the mid element recursion is done
		*with the right array
		*/
		else if (target >= ar[mid]) {
			if (right.length == 1) {
				if (right[0] == target) {
					targetIndex = max;
				} else {
					targetIndex = -1;
				}
			} else {
				min += mid;
				binarySearch(right, target, min, max);
			}
		}
		
/*
 * Finally we return the targetIndex to the calling method
 * if the number we've entered is not in the array we've passed -1 is returned.
 */
		return targetIndex;

	}

}
