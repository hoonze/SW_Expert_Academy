package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IM_꽃나리반_숫자_꾸미기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String s = br.readLine();
			int[] arr = new int[10];

			int total = 0;
			for (int i = 0; i < s.length(); i++) {
				arr[s.charAt(i) - '0']++;
			}

			arr[6] = (arr[6] + arr[9]) / 2 + (arr[6] + arr[9]) % 2;
			arr[9] = 0;

			for (int i = 0; i < 10; i++) {
				total = Math.max(total, arr[i]);
			}
			sb.append("#").append(t).append(" ").append(total).append("\n");
		}
		System.out.println(sb.toString());
	}
}
