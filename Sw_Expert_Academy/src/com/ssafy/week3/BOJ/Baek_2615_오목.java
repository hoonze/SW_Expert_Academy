package com.ssafy.week3.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2615_오목 {
	static int[][] go;
	static int N = 20;
	static int[] X = { -1, 0, 1, 1 };
	static int[] Y = { 1, 1, 1, 0 };
	static int max = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		go = new int[N][N];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N; j++) {
				go[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (go[i][j] == 1 || go[i][j] == 2) {//바둑알이 놓아져 있을때
					for(int d = 0; d < 4; d++) { //4방위만 탐색
						int bx = i - X[d];
						int by = j - Y[d];
						//현재 바둑알 방향 반대 방향에 바둑알이 있다면 확인 안함
						if(bx < 0 || by < 0 || bx >= N || by >= N || go[bx][by] == go[i][j])
							continue;
						if(dfs(i, j, 1, d)) {
							System.out.println(go[i][j]);
							System.out.println(i + " " + j);
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
	}

	static boolean dfs(int x, int y, int cnt , int dir) {
		int nx = x + X[dir];
		int ny = y + Y[dir];
			
		//다른 색을 만나거나 범위를 벗어날 경우
		if(nx < 0 || ny < 0 || nx >= N || ny >= N || go[nx][ny] != go[x][y]) {
			if(cnt == 5) //5개라면 승리
				return true;
			else //아닐경우 승리x
				return false;
		}
		return dfs(nx, ny, cnt+1, dir);
	}
}
