package com.ssafy.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//input
//3
//6
//A B C D E F
//4
//JACK QUEEN KING ACE
//5
//ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA

public class PerfectShuffle {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++){
			int n = Integer.parseInt(br.readLine());
			String[] s = new String[n];
			StringBuilder sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				s[i] = st.nextToken();
			}
			
			System.out.print("#" + t + " ");
			
			int cnt =0;			
			if(n%2 == 1) {
				cnt = 1;
			}
			
			for(int i = 0; i < n; i++) {
				if(i%2 == 0) {
					sb.append(s[i/2] + " ");
				}
				else {
					sb.append(s[n/2 + cnt] + " ");
					cnt++;
				}
			}
			System.out.print(sb.toString());
			System.out.println();
		}
	}
}
