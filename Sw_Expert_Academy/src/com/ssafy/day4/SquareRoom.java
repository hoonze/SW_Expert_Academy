package com.ssafy.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquareRoom {
	static int[][] arr;
	static int[] X = { 0, 0, 1, -1 };
	static int[] Y = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static int max, now, cnt;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = 1;
			now = 987654321;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 0;
					dfs(i, j);
					if (max == cnt) {
						if (now > arr[i][j])
							now = arr[i][j];
					} else if (max < cnt) {
						max = cnt;
						now = arr[i][j];
					}
				}
			}
			System.out.println("#" + t + " " + now + " " + max);
		}

	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt++;

		for (int i = 0; i < 4; i++) {
			int dx = x + X[i];
			int dy = y + Y[i];
			if (dx < 0 || dy < 0 || dx >= N || dy >= N)
				continue;

			if (arr[dx][dy] - arr[x][y] == 1 && !visited[dx][dy]) {
				dfs(dx, dy);
			}
		}
		visited[x][y] = false;

	}
}
