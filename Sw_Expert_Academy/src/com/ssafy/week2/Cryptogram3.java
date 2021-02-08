package com.ssafy.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Cryptogram3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			LinkedList<Integer> list = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());//암호문 길이
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {//암호문 길이만큼 암호문 입력
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int command = Integer.parseInt(br.readLine());//명령어 갯수 입력
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < command; i++) {
				String cmd = st.nextToken();
				switch(cmd){
					case "I":
						int target = Integer.parseInt(st.nextToken());
						int targetCnt = Integer.parseInt(st.nextToken());
						
						for(int j = 0; j < targetCnt; j++) {
							list.add(target++, Integer.parseInt(st.nextToken()));
						}
						break;
					case "D":
						int Dtarget = Integer.parseInt(st.nextToken());
						int DCnt = Integer.parseInt(st.nextToken());
						
						for(int j = 0; j < DCnt; j++) {
							list.remove(Dtarget+1);
						}
						break;
					case "A":
						int ACnt = Integer.parseInt(st.nextToken());
						for(int j = 0; j < ACnt; j++) {
							list.addLast(Integer.parseInt(st.nextToken()));
						}
						break;
				}
			}
			System.out.print("#" + t + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

}
