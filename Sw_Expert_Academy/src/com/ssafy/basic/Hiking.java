package com.ssafy.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hiking {
	static int[][] map;
	static int[] X = { 0, 0, -1, 1 };
	static int[] Y = { 1, -1, 0, 0 };
	static int n,k,answer =0;
	static LinkedList<Pos> q;
	
	static class Pos{
		int x;
		int y;
		int cnt;
		
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static void bfs() {
		int cnt = 0;
		while(!q.isEmpty()) {
			Pos now = q.poll();			
			for(int i = 0; i < 4; i++) {
				int dx = now.x + X[i];
				int dy = now.y + Y[i];
				
				if(dx < 0 || dy < 0 || dx >= n || dy >= n)
					continue;
				
				if(map[now.x][now.y] <= map[dx][dy]) {
					while(k--!=0) {
						for(int j = 0; j < 4; j++) {
							int xx = dx + X[j];
							int yy = dy + X[j];
						}
						
						
					}
				}
				
				q.add(new Pos(dx, dy, now.cnt+1));
				answer = Math.max(answer, q.peekLast().cnt);
			}
			
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int max = -1;
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			q = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == max) {
						q.add(new Pos(i, j, 1));
						bfs();
					}
				}
			}

			System.out.println(answer);
		}
	}


}
