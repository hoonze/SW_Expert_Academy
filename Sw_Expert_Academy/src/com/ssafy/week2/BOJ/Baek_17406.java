package com.ssafy.week2.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//배열 돌리기
public class Baek_17406 {
	static int[][] map, temp;
	static int N, M, K;
	static boolean[] visited;
	static Val[] val;
	static int[] res;
	static int min = 987654321;
	
	static class Val {
		int a;
		int b;
		int c;

		public Val(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	static void rotate(Val v) {
		int ROW = v.a - v.c;
		int COL = v.b - v.c;
		int dir = 1;
		int n = v.a + v.c;
		int m = v.b + v.c;
		for (int i = 0; i < Math.min(n, m); i++, n--, m--) {
			// 가로
			int row = ROW + i;
			int col = COL + i;
			int start = temp[row][col];
			// 세로
			for (int j = i; j < n - ROW; j++) {
				temp[row][col] = temp[row + dir][col];
				row += dir;
			}

			// 가로
			for (int j = i; j < m - COL; j++) {
				temp[row][col] = temp[row][col + dir];
				col += dir;
			}
			dir *= -1;
			// 역세로
			for (int j = i; j < n - ROW; j++) {
				temp[row][col] = temp[row + dir][col];
				row += dir;
			}
			// 역가로
			for (int j = i; j < m - COL; j++) {
				temp[row][col] = temp[row][col + dir];
				col += dir;
			}

			temp[row][col + 1] = start;

			dir *= -1;
		}
	}

	static void copyMap() {
		temp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}

	// 순열
	static void dfs(int cnt) {
		if (cnt == K) {
			copyMap();
			for (int k = 0; k < res.length; k++) {
				rotate(val[res[k]]);
			}
			for(int i = 1; i <= N; i++) {
				int sum = 0;
				for(int j = 1; j <= M; j++) {
					sum += temp[i][j];
				}
				min = Math.min(min, sum);
			}
			return;
		}

		for (int i = 0; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				res[cnt] = i;
				dfs(cnt + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());// 연산 횟수
		map = new int[N + 1][M + 1];
		visited = new boolean[K]; // 순열 중복 확인용
		res = new int[K];// 순열에서 사용
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		val = new Val[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			// (a-c,b-c) ~ (a+c, b+c)
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			Val v = new Val(a, b, c);
			val[i] = v;
		}
		dfs(0);
		System.out.println(min);
	}
}
