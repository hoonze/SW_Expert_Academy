package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//더 줄일수 있는방법 찾아보기
public class SWEA_최적경로 {
    static int N, ans;
    static Pos[] pos;
    static Pos[] temp;
    static boolean[] check;
    static Pos start, end;
 
    static class Pos {
        int x, y;
 
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
 
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            pos = new Pos[N];
            temp = new Pos[N];
            check = new boolean[N];
            ans = 987654321;
 
            start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 0; i < N; i++) {
                pos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
 
            len(0, 0);
            sb.append("#" + t + " " + ans + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    static void len(int cnt, int sum) {
        if (sum > ans) {
            return;
        }
        if (cnt == N) {
            int tSum = 0;
            tSum += Math.abs(temp[0].x - start.x) + Math.abs(temp[0].y - start.y);
            tSum += Math.abs(temp[N - 1].x - end.x) + Math.abs(temp[N - 1].y - end.y);
            for (int i = 0; i < N - 1; i++) {
                tSum += Math.abs(temp[i].x - temp[i + 1].x) + Math.abs(temp[i].y - temp[i + 1].y);
            }
            ans = Math.min(ans, tSum);
            return;
        }
 
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                temp[cnt] = new Pos(pos[i].x, pos[i].y);
                if (cnt != 0) {
                    len(cnt + 1,
                            sum + (Math.abs(temp[cnt].x - temp[cnt - 1].x) + Math.abs(temp[cnt].y - temp[cnt - 1].y)));
                } else {
                    len(cnt + 1, sum);
                }
                check[i] = false;
            }
        }
    }
}
