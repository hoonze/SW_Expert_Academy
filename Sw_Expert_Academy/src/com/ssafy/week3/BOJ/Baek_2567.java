package com.ssafy.week3.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2567 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];		
		
		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = x; i < x+10; i++) {
				for(int j = y; j < y+10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		int[] X = {-1,0,1,0};
		int[] Y = {0,1,0,-1};
		
		int cnt = 0;
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j <101; j++) {
				if(arr[i][j] == 0) {
					for(int d = 0; d < 4; d++) {
						int nx = i + X[d];
						int ny = j + Y[d];
						
						if(nx < 0 || ny < 0 || nx >=101 || ny >= 101)
							continue;
						
						if(arr[nx][ny] == 1) {
							arr[nx][ny] = 2;
							cnt++;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(cnt);
		
	}
}
