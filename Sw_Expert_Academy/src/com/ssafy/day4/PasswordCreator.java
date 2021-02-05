package com.ssafy.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PasswordCreator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q;
		StringTokenizer st;
		for(int t = 1; t <= 10; t++) {
			int a = Integer.parseInt(br.readLine());
			q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 1;
			while(true) {
				int now = q.poll();
				
				if(now - cnt <=0) {
					now = 0;
					q.offer(now);
					break;
				}
				
				now -= cnt;
				q.offer(now);
				cnt+=1;
				if(cnt > 5)
					cnt = 1;
			}
			
			System.out.print("#" + a + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}

}
