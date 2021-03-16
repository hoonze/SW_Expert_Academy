package com.ssafy.week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//방향성 그래프
public class SWEA_contact {
	static int N, Start, max;
	static ArrayList<ArrayList<Integer>> al;
	static int[] check;

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(Start);
		check[Start] = 1;
		int cnt = 0;
		int now;
		while(!q.isEmpty()) {
			now = q.poll();
			
			for(int i = 0; i < al.get(now).size(); i++) {
				if(check[al.get(now).get(i)] != 0)
					continue;
				
				check[al.get(now).get(i)] = check[now]+1;
				q.offer(al.get(now).get(i));
			}
			cnt = cnt < check[now] ? check[now] : cnt;
		}
		
		for(int i = 1; i < 101; i++) {
			if(check[i] != cnt)
				continue;
			
			max = Math.max(max, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Start = Integer.parseInt(st.nextToken());
			al = new ArrayList<ArrayList<Integer>>();
			
			check = new int[101];
			max = 0;

			for (int i = 0; i <= 100; i++) {
				al.add(new ArrayList<>());
			}

			int from, to;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				al.get(from).add(to);
			}
			bfs();
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
