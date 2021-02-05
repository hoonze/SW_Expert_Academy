package com.ssafy.basic;

import java.util.Arrays;
import java.util.Scanner;

public class test {
	static String arr[];
	static String res[];
	static boolean check[];
	static int n, r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 3;
		r = 2;
		
		arr = new String[n];
		res = new String[r];
		check = new boolean[n+1];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		
		dfs(0);
	}
	
	static void dfs(int cnt) {
		if(cnt == r) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!check[i]) {
				check[i] = true;
				res[cnt] =  arr[i];
				dfs(cnt+1);
				check[i] = false;
			}
		}
	}
}
