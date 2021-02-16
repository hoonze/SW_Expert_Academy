package com.ssafy.week3.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2961_bitmask {
	static int[][] arr;
	static int min  = Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); //신맛
			arr[i][1] = Integer.parseInt(st.nextToken()); //쓴맛
		}
		
		sub(1<<N);
		
		System.out.println(min);
	}
	
	private static void sub(int caseCount) {
		for(int i = 1; i < caseCount; i++) {
			int sSum = 1, bSum = 0;
			for(int j = 0; j < N; j++) {
				if((i & 1 << j) != 0) {
					sSum *= arr[j][0];
					bSum += arr[j][1];
				}
			}
			min = Math.min(min, Math.abs(sSum - bSum));
		}
	}
}
