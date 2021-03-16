package com.ssafy.week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_미로2 {
	static int[][] map;
	static int[] X = {-1,0,1,0};
	static int[] Y = {0,1,0,-1};
	static Pos start, end;
	
	static class Pos{
		int x, y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(start);
		
		Pos pos;
		while(!q.isEmpty()) {
			pos = q.poll();
			
			int nx, ny;
			for(int i = 0; i < 4; i++) {
				nx = pos.x + X[i];
				ny = pos.y + Y[i];
				
				if(nx == end.x && ny == end.y)
					return true;
				
				if(nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || map[nx][ny] != 0)
					continue;
				
				map[nx][ny] =3;
				q.offer(new Pos(nx,ny));
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			map = new int[100][100];
			for(int i = 0; i < 100; i++) {
				String s = br.readLine();
				for(int j = 0; j < 100; j++) {
					map[i][j] = s.charAt(j) - '0';
					if(map[i][j] == 2) {
						start = new Pos(i,j);
					}else if (map[i][j] == 3) {
						end = new Pos(i,j);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(bfs() == true ? 1 : 0).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

