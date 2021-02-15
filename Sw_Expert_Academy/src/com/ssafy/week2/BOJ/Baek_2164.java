package com.ssafy.week2.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//카드 2
public class Baek_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		while(q.size()!=1) {
			q.poll();
			int temp = q.poll();
			q.offer(temp);
		}
		System.out.println(q.peek());
	}

}
