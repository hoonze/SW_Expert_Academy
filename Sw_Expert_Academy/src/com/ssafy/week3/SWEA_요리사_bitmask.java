package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_요리사_bitmask {
	static int N;
	static int[][] arr;
	static boolean[] recipe;
	static ArrayList<Integer> a, b;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			recipe = new boolean[N];
			a = new ArrayList<>();
			b = new ArrayList<>();
			min = 987654321;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bit(1 << N);
			sb.append("#" + t + " " + min + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bit(int caseCnt) {
		int cnt = 0;
		for (int i = 1; i < caseCnt/2; i++) {
			cnt = 0;
			recipe = new boolean[N];
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					cnt++;
					recipe[j] = true;
				}
			}
			if (cnt == N / 2) {
				for (int j = 0; j < N; j++) {
					if (recipe[j]) {
						a.add(j); // a 레시피에 추가
					} else
						b.add(j); // b레시피에 추가
				}
				min = Math.min(min, Math.abs(perm(a) - perm(b)));
				a.clear();
				b.clear();
			}
		}
	}

	// 레시피의 합을 계산하는 메서드
	static int perm(ArrayList<Integer> temp) {
		int sum = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				sum += arr[temp.get(i)][temp.get(j)];
			}
		}
		return sum;
	}

}
