package Lec2;

import java.util.Scanner;

public class Pattern19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int row=1, nst=n/2, nsp=1; row<=n; row++) {
			for(int cst = 1; cst<=nst; cst++) {
				System.out.print("*");
			}
			for(int csp=1; csp<=nsp; csp++) {
				System.out.print(" ");
			}
			for(int cst = 1; cst<=nst; cst++) {
				System.out.print("*");
			}
			if(row<=n/2) {
				nst--;
				nsp+=2;
			}
			else {
				nst++;
				nsp-=2;
			}
			System.out.println();
		}
	}

}
