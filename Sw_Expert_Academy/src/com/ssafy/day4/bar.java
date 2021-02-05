package com.ssafy.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bar {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String s = br.readLine();
			int total = 0;
			int bar = 0;
			
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(')
					bar++;
				
				else {
					bar--;
					
					if(s.charAt(i-1) == '(')
						total += bar;
					
					else 
						total++;
					
				}
			}
			System.out.println("#" + t + " " + total);
		}
	}
}
