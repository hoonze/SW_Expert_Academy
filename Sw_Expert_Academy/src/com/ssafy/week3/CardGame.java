package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//규영이와 인영이의 카드게임1
public class CardGame {
	static boolean[] cards;
	static int[] A;
	static int[] B;
	static int[] numbers;
	static boolean[] Selected;
	static int win, lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			cards = new boolean[19];
			A = new int[9];//규영
			B = new int[9];//인영
			numbers = new int[9];
			Selected = new boolean[9];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				int k = Integer.parseInt(st.nextToken());
				cards[k] = true;
				A[i] = k;
			}
			int cnt = 0;
			for (int i = 1; i < 19; i++) {
				if (!cards[i])
					B[cnt++] = i;
			}
			win = 0;
			lose = 0;
			dfs(0);

			sb.append("#" + t + " " + win + " " + lose + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cnt) {
		if (cnt == 9) {
			int aSum =0;
			int bSum =0;
			for(int i = 0; i < 9; i++) {
				if(numbers[i] > B[i]) {
					aSum +=  numbers[i] + B[i];
				}
				else 
					bSum += numbers[i] + B[i];
			}
			if(aSum > bSum) win++;
			else lose++;
			return;
		}

		for(int i = 0; i < 9; i++) {
			if(!Selected[i]) {
				Selected[i] = true;
				numbers[cnt] = A[i];
				dfs(cnt + 1);
				Selected[i] = false;
			}
		}
	}
}
