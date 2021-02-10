package com.ssafy.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//사칙연산 유효성
public class OperationValidity {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = 0;
		while (t++ < 10) {
			int result = 1;
			boolean possible = true;
			int N = Integer.parseInt(br.readLine());
			while (N-- > 0) {
				if(possible) {
					String[] s = br.readLine().split(" ");
					int n = s[1].charAt(0) - 48;
					if(1 <= n && n <= 9) {
						if(s.length <=2) {
							continue;
						}
						result = 0;
						possible = false;
					}
				}
				else
					br.readLine();
					
			}
			System.out.println("#" + t + " " + result);
		}
	}

}
