package com.ssafy.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			int a = Integer.parseInt(br.readLine());
			String s = br.readLine();
			boolean flag = true;
			System.out.print("#" + t + " ");
			char c = 123;
			Stack<Character> st = new Stack<>();
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '<') {
					st.push(s.charAt(i));
					continue;
				}
				if(st.peek() == '(') {
					if(s.charAt(i) != ')'){
						flag = false;
						break;
					}
				}
				else {
					if((char)(st.peek()+2) != s.charAt(i)) {
						flag = false;
						break;
					}
				}
				st.pop();
			}
			if(st.isEmpty()) {
				System.out.println(flag ? 1 : 0);				
			}
			else
				System.out.println(0);

		}
		br.close();
	}
}
