package com.ssafy.week3.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1592_영식이와_친구들 {
	static int N, M, L;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		int i = 0;
		int cnt = 0;
		while(true) {
			arr[i]++;
			if(arr[i] == M)
				break;
			cnt++;
			if(arr[i] %2 == 1) {
				i = (i+L)%N;
			}
			else {
				i = (i-L);
				if(i<0)
					i+=N;
			}
		}
		System.out.println(cnt);
	}
}
