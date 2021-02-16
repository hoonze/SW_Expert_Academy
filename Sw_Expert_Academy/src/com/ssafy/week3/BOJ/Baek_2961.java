package com.ssafy.week3.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2961 {
	static int[][] arr;
	static boolean[] visited;
	static int min  = Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); //신맛
			arr[i][1] = Integer.parseInt(st.nextToken()); //쓴맛
		}
		
		combi(0,1,0);
		
		System.out.println(min);
	}
	
	private static void combi(int idx, int s, int b) {
		if(idx == N) {
			if(b!=0) 
				min = Math.min(min, Math.abs(s-b));
			return;
		}
		
		visited[idx] = true;
		combi(idx+1, s * arr[idx][0], b + arr[idx][1]);
		visited[idx] = false;
		combi(idx + 1, s, b);
	}
}
