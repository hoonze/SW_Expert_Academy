package com.ssafy.week3.BOJ;

import java.util.Scanner;

public class Baek_2839_설탕_배달 {
	static int N, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int result = 0;
		while(N % 5 != 0 && N>0) {
			N -= 3;
			result++;
		}
		if(N%5 != 0) {
			result = -1;
		}
			System.out.println(N/5 + result);
	}

}