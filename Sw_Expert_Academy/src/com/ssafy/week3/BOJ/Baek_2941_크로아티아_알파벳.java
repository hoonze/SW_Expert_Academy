package com.ssafy.week3.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2941_크로아티아_알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] compair = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="}; 
		String s = br.readLine();
		
		for(int i = 0; i < compair.length; i++) {
			s = s.replace(compair[i], " ");
		}
		System.out.println(s.length());
	}	
}
