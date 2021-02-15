package com.ssafy.week3.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11723 {	
	static int[] arr;
	static int bit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int n;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			
			switch(str) {
				case "add":
					n = Integer.parseInt(st.nextToken());
					add(n);
					break;
				case "remove":
					n = Integer.parseInt(st.nextToken());
					remove(n);
					break;
				case "check":
					n = Integer.parseInt(st.nextToken());
					sb.append(check(n) + "\n");
					break;
				case "toggle":
					n = Integer.parseInt(st.nextToken());
					toggle(n);
					break;
				case "all":
					all();
					break;
				case "empty":
					empty();
					break;
			}
		}
		System.out.println(sb);
	}
	
	private static void add(int n) {
		bit |= (1 << n-1);
	}
	
	private static void remove(int n) {
		bit &= ~(1 << n-1);
	}
	
	private static int check(int n) {
		if((bit & (1 << n-1)) != 0)
			return 1;
		return 0;
	}
	
	private static void toggle(int n) {
		bit ^= (1 << n-1);
	}
	
	private static void all() {
		bit = Integer.MAX_VALUE;
	}
	
	private static void empty() {
		bit = 0;
	}
}
