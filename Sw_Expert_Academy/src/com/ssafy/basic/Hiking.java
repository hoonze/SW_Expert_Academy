package com.ssafy.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hiking {
	static int[][] map;
	static boolean[][] check;
	static int[] X = { -1, 0, 1, 0 };
	static int[] Y = { 0, 1, 0, -1 };
	static int N, K, answer;

	static void dfs(int x, int y, int k, int now, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nx = x + X[i];
			int ny = y + Y[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N || check[nx][ny])
				continue;

			
			if (now <= map[nx][ny] && k > 0) {
				for (int j = 1; j <= k; j++) {
					if (now <= map[nx][ny] - j)
						continue;
					check[nx][ny] = true;
					dfs(nx, ny, 0, map[nx][ny]-j, cnt + 1);
					check[nx][ny] = false;
				}
				continue;
			}
			if(now > map[nx][ny]) {
				check[nx][ny] = true;
				dfs(nx, ny, k, map[nx][ny], cnt + 1);
				check[nx][ny] = false;
			}
		}
		answer = Math.max(answer,cnt);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int max = -1;
			map = new int[N][N];
			check = new boolean[N][N];
			answer = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						check[i][j] = true;
						dfs(i, j, K, map[i][j], 1);
						check[i][j] = false;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
