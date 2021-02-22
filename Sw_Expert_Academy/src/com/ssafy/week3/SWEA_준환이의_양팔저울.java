package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_준환이의_양팔저울 {
	static int N;
	static int[] arr;
	static int[] temp;
	static boolean[] check;
	static int totalCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			temp = new int[N];
			check = new boolean[N];
			totalCnt = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			perm(0);
			sb.append("#" + t + " " + totalCnt+ "\n");
		}
		System.out.println(sb);
	}

	static void subset(int cnt, int lSum, int rSum) {
		if(cnt == N) {
			totalCnt++;
			return;
		}
		
		if(lSum >= rSum + temp[cnt]) {
			subset(cnt+1, lSum, rSum + temp[cnt]);
		}
		subset(cnt+1, lSum+temp[cnt], + rSum);
	}
	
	static void perm(int cnt) {
		if (cnt == N) {
			subset(0,0,0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				temp[cnt] = arr[i];
				perm(cnt+1);
				check[i] = false;
			}
		}
	}
}
