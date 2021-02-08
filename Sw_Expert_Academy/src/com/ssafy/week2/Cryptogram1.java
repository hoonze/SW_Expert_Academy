package com.ssafy.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Cryptogram1 {

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
			String[] input = br.readLine().split("I");

			for(int i = 1; i <= command; i++) {
				st = new StringTokenizer(input[i], " ");
				int target = Integer.parseInt(st.nextToken());
				int targetCnt = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j < targetCnt; j++) {
					int a = Integer.parseInt(st.nextToken());
					list.add(target++, a);
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
