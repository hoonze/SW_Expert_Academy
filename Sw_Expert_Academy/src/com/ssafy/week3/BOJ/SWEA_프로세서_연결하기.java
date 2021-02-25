package com.ssafy.week3.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_프로세서_연결하기 {
	static int N;
	static int[][] map;
	static int[] X = { -1, 0, 1, 0 };
	static int[] Y = { 0, 1, 0, -1 };
	static ArrayList<Pos> al;
	static int max = -1;
	static int minLen = Integer.MAX_VALUE;

	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void dfs(int idx, int cnt, int sum) {
		if (idx == al.size()) {
			if (max < cnt) {
				max = cnt;
				minLen = sum;
			} else if (max == cnt && minLen > sum) {
				minLen = sum;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = al.get(idx).x;
			int ny = al.get(idx).y;
			int len = 0;

			
			while (true) {
				nx += X[i];
				ny += Y[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					break;
				}

				if (map[nx][ny] != 0) {
					len = 0;
					break;
				}

				len++;
			}
			nx = al.get(idx).x;
			ny = al.get(idx).y;

			if (len == 0) {
				continue;
			} else {
				for (int d = 0; d < len; d++) {
					nx += X[i];
					ny += Y[i];
					map[nx][ny] = 2;
				}

				dfs(idx + 1, cnt + 1, sum + len);

				nx = al.get(idx).x;
				ny = al.get(idx).y;
				for (int d = 0; d < len; d++) {
					nx += X[i];
					ny += Y[i];
					map[nx][ny] = 0;
				}
			}
		}
		dfs(idx + 1, cnt, sum);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			al = new ArrayList<>();
			max = -1;
			minLen = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 &&i!=0 && j!=0 && i!=N-1 && j!=N-1) {
						al.add(new Pos(i, j));
					}
				}
			}
			dfs(0, 0, 0);
			sb.append("#").append(t).append(" ").append(minLen).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
