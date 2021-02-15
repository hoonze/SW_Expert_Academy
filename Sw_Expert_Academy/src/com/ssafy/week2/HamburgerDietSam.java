package com.ssafy.week2;

import java.util.Scanner;

//햄버거 다이어트 부분집합
public class HamburgerDietSam {
    static int N, L;   // 가짓수, 칼로리 제한값
    static int[] s; //배열 맛
    static int[] k; //배열 칼로리
    static int res = 0; //최대값 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        
        

    for(int t = 1; t <= TC; t++) {
        res = 0; // 가장 작은값
        N = sc.nextInt();
        L = sc.nextInt();
        s = new int[N];
        k = new int[N];
        
//            입력
            for(int i = 0; i < N; i++) {
                s[i] = sc.nextInt();
                k[i] = sc.nextInt();
            }
//            구현

            dfs(0, 0, 0);
//            출력
            System.out.println("#"+t + " " + res);
        }

}
//  매번 반복하면서 바뀌는 값 매개변수 전달
    private static void dfs(int idx, int sSum, int kSum) {
//        햄버거의 칼로리는 양의 정수  + 계속 증가
//        L 1000   N 20    13번째 1200; 14~20
        if(kSum > L) {  // 알고리즘 시험
            return;
        }
//        종료
        if(idx == N) {
//            최대값 구하기 todo 시뮬레이션
//            if(kSum <= L) {
                res = Math.max(res, sSum);
//            }
            return;
        }
//        실행

//        재귀
        dfs(idx + 1, sSum + s[idx], kSum + k[idx]);  //먹은 경우
        dfs(idx + 1, sSum, kSum);  //안먹은 경우

    }

}