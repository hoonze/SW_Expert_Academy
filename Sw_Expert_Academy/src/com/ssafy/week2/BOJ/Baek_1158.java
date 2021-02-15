package com.ssafy.week2.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//요세푸스
public class Baek_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		while(!q.isEmpty()) {
			for(int i = 0; i < k-1; i++) {
				q.offer(q.peek());
				q.poll();
			}
			
			sb.append(q.poll());
			if(!q.isEmpty())
				sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}
