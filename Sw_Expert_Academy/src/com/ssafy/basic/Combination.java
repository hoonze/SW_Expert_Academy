package com.ssafy.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
	static int arr[];
	static int res[];
	static int n, r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
		n = 3;
		r = 2;
		
		arr = new int[n];
		res = new int[n-1];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("#" + t);
		dfs(0, 0);
		
		}
	}
	
	static void dfs(int start, int cnt) {
		if(cnt == r) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i = start; i < n; i++) {
			res[cnt] = arr[i];
			dfs(i+1, cnt+1);
		}
		
	}
}
