package com.ssafy.week3.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_17135_캐슬_디펜스 {
	static int N, M, L;
	static int[][] map;
	static int[][] temp;
	static int[] Archer;
	static int totalCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Archer = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0, 0);
		System.out.println(totalCnt);
	}

	static void copyMap() {
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}

	static int attack() {
		boolean[][] dead = new boolean[N][M];
		int min;

		for (int a = 0; a < 3; a++) { // 궁수의 위치
			min = 987654321;
			boolean flag = false;
			int x = 0, y = 0;
			for (int i = N - 1; i >= 0; i--) { //
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 1) { // 적이 있는 위치일때
						int len = (N - i) + Math.abs(Archer[a] - j);
						// 적이 사정거리 안에 있고 가장 짧은 거리라면
						if (len <= L && min > len) {
							min = len;
							x = i;
							y = j;
							flag = true;
						}
						
						//거리가 같다면 왼쪽에 있는 적 우선 공격
						if(len == min && y > j) {
							x = i;
							y = j;
						}
					}
				}

			}
			if (flag) {
				dead[x][y] = true;
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dead[i][j] == true) {
					cnt++;
					temp[i][j] = 0;
				}
			}
		}
		return cnt;
	}

	// 적 이동
	static void move() {
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = temp[i - 1][j];
			}
		}
		for (int i = 0; i < M; i++) {
			temp[0][i] = 0;
		}
	}

	// 궁수 조합
	static void combi(int idx, int cnt) {
		if (cnt == 3) {
			int deadCnt = 0;
			copyMap();
			for (int t = 0; t < N; t++) {
				deadCnt += attack();
				move();
			}
			totalCnt = Math.max(totalCnt, deadCnt);
			return;
		}

		for (int i = idx; i < M; i++) {
			Archer[cnt] = i;
			combi(i + 1, cnt + 1);
		}
	}
}
