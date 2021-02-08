package com.ssafy.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HamburgerDiet {
	static int N, L;
	static int[][] arr;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());//Testcase 갯수

		for (int t = 1; t <= T; t++) {
			max = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); // 맛
				arr[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			Combination(0,0,0);
			System.out.println("#" + t + " " + max);
		}

	}

	static void Combination(int start, int calSum, int taste) {
		if (calSum > L) {
			max = Math.max(max,  taste - arr[start-1][0]);
			return;
		}else if(start  == N || calSum == L) {
			max = Math.max(max,  taste);
			return;
		}

		for (int i = start; i < N; i++) {
			Combination(i+1, calSum + arr[i][1], taste + arr[i][0]);
		}
	}
}
