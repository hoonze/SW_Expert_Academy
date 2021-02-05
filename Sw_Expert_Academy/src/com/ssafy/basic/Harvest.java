package com.ssafy.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Harvest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int sum = 0;
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];

			// 입력
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}

			int len = 0;
			for (int i = 0; i < n; i++) {
				//농장크기 중간을 기준으로
				for (int j = (n / 2) - len; j <= (n / 2) + len; j++) {
					sum += arr[i][j];
				}
				
				//중간열부터 len을 줄여가면서 확인
				if (i >= (n / 2)) {
					len -= 1;
					continue;
				}
				len += 1;
			}
			System.out.println("#" + t + " " + sum);
		}
	}

}
