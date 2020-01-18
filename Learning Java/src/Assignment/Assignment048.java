package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take as input N, the size of array. Take N more inputs and store that in an array. Take as input “target”, a number. Write a function which prints all triplets of numbers which sum to target.
//
//		Input Format
//		First line contains input N.
//		Next line contains N space separated integers denoting the elements of the array.
//		The third line contains a single integer T denoting the target element.
//
//		Constraints
//		Length of Array should be between 1 and 1000.
//
//		Output Format
//		Print all the triplet present in the array in a new line each. The triplets must be printed as A, B and C where A,B and C are the elements of the triplet ( A<=B<=C) and all triplets must be printed in sorted order. Print only unique triplets.
//
//		Sample Input
//		9
//		5 7 9 1 2 4 6 8 3
//		10
//		Sample Output
//		1, 2 and 7
//		1, 3 and 6
//		1, 4 and 5
//		2, 3 and 5
//		Explanation
//		Array = {5, 7, 9, 1, 2, 4, 6 ,8 ,3}. Target number = 10. Find any three number in the given array which sum to target number.

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();
		int t = scn.nextInt();
		targetSumTriplets(arr, t);

	}

	public static void targetSumTriplets(int[] arr, int t) {
		Arrays.sort(arr);
		int start = 0;
		while (start < arr.length - 2) {
			int mid = start + 1;
			int end = arr.length - 1;
			while (mid < end) {
				int sum = arr[start] + arr[mid] + arr[end];
				if (sum < t)
					mid++;
				else if (sum > t)
					end--;
				else {
					System.out.println(arr[start] + ", " + arr[mid] + " and " + arr[end]);
					mid++;
					end--;
				}
			}
			start++;
		}
	}

}