package Assignment;

import java.util.Scanner;

public class CalculateTheSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Raj is a very smart kid who recently started learning computer programming. His coach gave him a cyclic array A having N numbers, and he has to perform Q operations on this array. In each operation the coach would provide him with a number X. After each operation, every element of the cyclic array would be replaced by the sum of itself and the element lying X positions behind it in the cyclic array. All these replacements take place simultaneously. For example, if the cyclic array was [a, b, c, d], then after the operation with X = 1, the new array would be [a+d, b+a, c+b, d+c]. He needs to output the sum of the elements of the final array modulus 10^9+7. He made a program for it but it's not very efficient. You know he is a beginner, so he wants you to make an efficient program for this task because he doesn't want to disappoint his coach.

		Input Format
		The first line of each test file contains a integer N. The next line contains N space separated integers which represent the elements of the cyclic array. The third line contains a integer Q representing the number of operations that will be applied to the array. Finally, Q lines follow, each one containing an integer X .

		Constraints
		1 <= N <= 100000
		1 <= Ai<= 10^9
		0 <= Q <= 1000000
		0 <= X < N

		Output Format
		Your program should output to the standard output stream the sum of the elements of the final array modulus 10^9+7.

		Sample Input
		5
		1 2 3 4 5
		2
		1
		0
		Sample Output
		60
		Explanation
		After the 1st operation (X = 1), the array would be [1+5, 2+1, 3+2, 4+3, 5+4] =[6, 3, 5, 7, 9]
		After 2nd operation (X = 0), the array would be [6+6, 3+3, 5+5, 7+7, 9+9] =[12, 6, 10, 14, 18]
		Thus the correct answer would equal to = (12+6+10+14+18) % (10^9+7) = 60
		*/
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();
		int q = scn.nextInt();
		for (int i = 1; i <= q; i++) {
			int x = scn.nextInt();
			applyOperation(arr, x);
		}
		int sum = 0;
		for (int val : arr)
			sum += val;
		int ans = sum % (int) (Math.pow(10, 9) + 7);
		System.out.println(ans);
	}

	public static void applyOperation(int[] arr, int x) {
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			temp[i] = arr[i];
		for (int i = 0; i < arr.length; i++) {
			int j = i - x;
			if (j < 0)
				j += arr.length;
			arr[i] += temp[j];
		}
		// Second way :- As we can see the sum doubles itself during each operations.
		// So we can multiply the sum by 2^Total no. of operations.

	}

}