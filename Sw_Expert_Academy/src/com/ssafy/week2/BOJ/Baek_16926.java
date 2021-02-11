package com.ssafy.week2.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//배열돌리기 1
public class Baek_16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());// 가로
		int M = Integer.parseInt(st.nextToken());// 세로
		int R = Integer.parseInt(st.nextToken());// 회전수
		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int row = 0;
		int col = 0;
		int dir = 1;
		int n = N;
		int m = M;
		int r = R ;
		for (int i = 0; i < Math.min(n, m); i++, n--, m--) {
			// 가로
			r = R % ((n-i)*2 + (m-i-2)*2);
			while (r-- > 0) {
				col = i;
				row = i;
				int start = arr[col][row];
				for (int j = i; j < m - 1; j++) {
					arr[col][row] = arr[col][row + dir];
					row += dir;
				}

				// 세로
				for (int j = i; j < n - 1; j++) {
					arr[col][row] = arr[col + dir][row];
					col += dir;
				}
				dir *= -1;
				// 역가로
				for (int j = i; j < m - 1; j++) {
					arr[col][row] = arr[col][row + dir];
					row += dir;
				}

				// 역세로
				for (int j = i; j < n - 1; j++) {
					arr[col][row] = arr[col + dir][row];
					col += dir;
				}
				arr[col + 1][row] = start;

				dir *= -1;

			}
		}

		for (int k = 0; k < N; k++) {
			for (int l = 0; l < M; l++)
				sb.append(arr[k][l] + " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
