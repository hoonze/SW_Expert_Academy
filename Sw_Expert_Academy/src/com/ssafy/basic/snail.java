package com.ssafy.basic;

import java.util.Scanner;

public class snail {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for (int t = 1; t <= test_case; t++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			int cnt = 1;
			int row = -1;
			int col = 0;
			int dir = 1;
			for (int i = n; i > 0; i--) {
				//가로
				for(int j = 0; j < i; j++) {
					row += dir;
					arr[col][row] = cnt++;
				}
				
				//세로
				for(int j = 0; j <i-1; j++) {
					col += dir;
					arr[col][row] = cnt++;
				}
				dir *= -1;
			}
			
			System.out.println("#" + t);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
