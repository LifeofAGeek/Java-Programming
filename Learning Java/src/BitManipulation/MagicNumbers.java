package BitManipulation;

public class MagicNumbers {

	public static void main(String[] args) {
		//Magic nos - Numbers which are power of 5 or sum of powers of 5.
		// Generate Magic nos. i.e. 5, 25, 30, etc
/*
 *    5^3  5^2  5^1
 *    -------------
 *     0    0    1	-> 1 = 5
 *     0	1	 0  -> 2 = 25
 *     0	1	 1  -> 3 = 30
 *     1	0 	 0  -> 4 = 125
 *     1	0	 1  -> 5 = 130
 *     1	1 	 0  -> 6 = 150
 *     1	1 	 1  -> 7 = 155
 *     
 */
		System.out.println(magicNumber(1));
		System.out.println(magicNumber(2));
		System.out.println(magicNumber(3));
		System.out.println(magicNumber(4));
		System.out.println(magicNumber(5));
		System.out.println(magicNumber(6));
		System.out.println(magicNumber(7));

	}
	
	public static int magicNumber(int ith) {
		int pow = 5;
		int sum = 0;
		while(ith != 0) {
			if((ith & 1) == 1) {
				sum += pow;
			}
			ith = ith >> 1;
			pow *= 5;
		}
		return sum;
	}

}
