package com.ssafy.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//swea 1220
public class Magnetic {
	static int N;
	static int[][] map;
	static Queue<Pos> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = 0; // 테스트 케이스
		while(t++ < 10) {
			N = Integer.parseInt(br.readLine()); //map의 크기
			map = new int[N][N];
			q = new LinkedList<>();
			int cnt = 0;
			
			for(int i = 0; i < N; i++) { // 입력
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						q.offer(new Pos(i, j, map[i][j])); // 좌표와 극 q에 입력
					}
				}
			}
			
			while(!q.isEmpty()) {
				Pos pos = q.poll();
				if(pos.mag == 1) { //N극 이므로 아래로 향함
					int nx = pos.x +1;
					int ny = pos.y;
					if(nx >= N) {//map범위 보다 커지면 밖으로 나감
						map[pos.x][pos.y] = 0;
						continue;
					}
					if(map[nx][ny] != 0) { //밑에 막혀있으므로 못움직임
						if(map[nx][ny] == 2) //밑이 다른 극성이면 있으므로 +1;
							cnt++;
						continue;
					}
					//밑이 비어있다면 밑으로 움직임
					map[nx][ny] = pos.mag;
					map[pos.x][pos.y] = 0;
					q.offer(new Pos(nx, ny, pos.mag));
				}
				else if(pos.mag == 2) { //S극 이므로 위로 향함
					int nx = pos.x -1;
					int ny = pos.y;
					if(nx < 0) {//map범위 보다 작아지면 밖으로 나감
						map[pos.x][pos.y] = 0;
						continue;
					}
					if(map[nx][ny] != 0) { //위가 막혀있으므로 못움직임
						continue;
					}
					//위가 비어있다면 위로 움직임
					map[nx][ny] = pos.mag;
					map[pos.x][pos.y] = 0;
					q.offer(new Pos(nx, ny, pos.mag));
				}
			}
			sb.append("#" + t + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
	
	static class Pos{
		int x;
		int y;
		int mag;
		
		public Pos(int x, int y, int mag) {
			this.x = x;
			this.y = y;
			this.mag = mag;
		}
	}
	

}
