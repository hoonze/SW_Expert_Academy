package com.ssafy.week3.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_4963_섬의_개수 {
	static int map[][];
	static int[] X = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] Y = { -1, -1, 0, 1, 1, 0, 1, -1 };

	static class xy {
		int x;
		int y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(int w, int h, int dx, int dy) {
		Queue<xy> q = new LinkedList<>();
		xy val = new xy(dx, dy);
		q.add(val);
		
		while(!q.isEmpty()) {
			val = q.poll();
			
			for(int i = 0; i < 8; i++) { // 8방위 탐색
				int nx = val.x + X[i];
				int ny = val.y + Y[i];
				
				//map범위를 벗어나면 continue;
				//섬이 아니라면 continue;
				if(nx<0 || ny <0 || nx >= h || ny >=w || map[nx][ny] != 1) 
					continue;
				
				map[nx][ny] = 3; // 갔던 곳임을 체크
				q.add(new xy(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			int cnt = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) { // 섬이라면 
						map[i][j] = 3; // 갔던 곳임을 체크
						bfs(w, h, i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
