package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_요리사 {
	static int N;
	static int[][] arr;
	static boolean[] recipe;
	static ArrayList<Integer> a, b;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			recipe = new boolean[N];
			a = new ArrayList<>();
			b = new ArrayList<>();
			min = 987654321;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combi(0,0);
			sb.append("#" + t + " " + min + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	//레시피의 합을 계산하는 메서드
	static int perm(ArrayList<Integer> temp) {
		int sum = 0;
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < N/2; j++) {
				sum+= arr[temp.get(i)][temp.get(j)];
			}
		}
		return sum;
	}
	
	//재료 조합
	static void combi(int idx, int cnt) {
		if(cnt == N/2) { // 재료가 N/2개가 채워졌다면
			for(int i = 0; i< N; i++) {
				if(recipe[i]) {
					a.add(i); //a 레시피에 추가
				}
				else
					b.add(i); //b레시피에 추가
			}
			//a와 b의 합을 계산해 그 차이가 min보다 작다면 min 변경
			min = Math.min(min, Math.abs(perm(a) - perm(b)));
			a.clear();
			b.clear();
			return;
		}

		//레시피 조합
		for(int i = idx; i < N; i++) {
			recipe[i] = true;
			combi(i+1, cnt+1);
			recipe[i] = false;
		}
	}
}
