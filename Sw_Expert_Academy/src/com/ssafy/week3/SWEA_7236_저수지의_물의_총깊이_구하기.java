package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_7236_저수지의_물의_총깊이_구하기 {
	static int N, max;
	static char[][] map;
	static int[] X = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] Y = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			max = 1;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			depth();
			sb.append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void depth() {
		int nx, ny;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cnt = 0;
				if(map[i][j] == 'W') {
					for(int d = 0; d < 8; d++) {
						nx = i + X[d];
						ny = j + Y[d];
						
						if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 'G')
							continue;
						
						cnt++;
					}
				}
				if(max < cnt) {
					max = cnt;
				}
			}
		}
	}
}
