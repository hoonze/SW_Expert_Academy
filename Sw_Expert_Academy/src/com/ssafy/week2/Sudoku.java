package com.ssafy.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//swea1974
public class Sudoku {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] map; //스도쿠 맵
		boolean[] rowCheck, colCheck;
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			map = new int[10][10];
			boolean possible = true;
			
			for(int i = 1; i < 10; i++) { //입력 
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j < 10; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			loop: // 세로 가로 줄에 겹치는 숫자가 있는지 확인
			for(int i = 1; i < 10; i++) {
				rowCheck = new boolean[10]; // 가로
				colCheck = new boolean[10]; // 세로
				for(int j = 1; j < 10; j++) {
					if(rowCheck[map[i][j]]||colCheck[map[j][i]]) {
						possible = false;
						break loop;
					}
					rowCheck[map[i][j]] = true;
					colCheck[map[j][i]] = true;
				}
			}
			
			//겹치는게 있다면 0 출력
			if(!possible) {
				sb.append(0 + "\n");
				continue;
			}
			
			
			int start = 1;
			int end = 3;
			boolean check[];
			loop2: //3x3에 같은수가 있는지 확인
			for(int i = 1; i <= 9; i+=3) {
				for(int j =1 ; j <= 9; j+=3) {
					check = new boolean[10];
					for(int x = i; x <= i+2; x++) {
						for(int y = j; y <= j+2; y++) {
							if(check[map[x][y]]) {
								possible = false;
								break loop2;
							}
							check[map[x][y]] = true;
						}
					}
				}
			}
			
			//겹치는게 있다면 0 출력
			if(!possible) {
				sb.append(0 + "\n");
				continue;
			}
			
			//없다면 1 출력
			sb.append(1 + "\n");
		}
		System.out.println(sb);
	}
}
