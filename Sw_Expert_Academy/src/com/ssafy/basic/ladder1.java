package com.ssafy.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ladder1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 100;
		int[][] ladder = new int[N][N];
		boolean[][] check = new boolean[N][N];
		int a = 0;
		int b = 0;

		for (int t = 1; t <= 10; t++) {
			// 입력
			check = new boolean[N][N];
			int task_case = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j] == 2) {
						a=i;
						b=j;
					}
						
				}
			}
	
			check[a][b] = true;
			while (true) {
				if (a == 0) {
					System.out.println("#" + t + " " + b);
					break;
				}

				if (b - 1 >= 0 && ladder[a][b - 1] == 1 && !check[a][b - 1]) {
					check[a][b - 1] = true;
					b = b - 1;
					continue;
				}
				
				if (b + 1 < N && ladder[a][b + 1] == 1 && !check[a][b + 1]) {
					check[a][b + 1] = true;
					b = b + 1;
					continue;
				}
				
				check[a-1][b] = true;
				a -= 1;
			}
		}
	}
}
