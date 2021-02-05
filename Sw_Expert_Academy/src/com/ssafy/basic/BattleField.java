package com.ssafy.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BattleField {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		char[][] map = null;
		for (int t = 1; t <= test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			map = new char[height][width];
			int row = 0;
			int col = 0;

			for (int i = 0; i < height; i++) {
				String s = br.readLine();
				for (int j = 0; j < s.length(); j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						row = i;
						col = j;
					}

				}
			}

			int n = Integer.parseInt(br.readLine());
			String command = br.readLine();

			// 명령문
			for (int i = 0; i < command.length(); i++) {
				char com = command.charAt(i);

				switch (com) {
				case 'U':
					if (row - 1 >= 0) {
						if (map[row - 1][col] == '.') {
							map[row - 1][col] = '^';
							map[row][col] = '.';
							row -= 1;
						} else {
							map[row][col] = '^';
						}
					}else {
						map[row][col] = '^';
					}

					break;
				case 'D':
					if (row + 1 < height) {
						if (map[row + 1][col] == '.') {
							map[row + 1][col] = 'v';
							map[row][col] = '.';
							row += 1;
						} else {
							map[row][col] = 'v';
						}
					}else {
						map[row][col] = 'v';
					}
					break;
				case 'L':
					if (col - 1 >= 0) {
						if (map[row][col - 1] == '.') {
							map[row][col - 1] = '<';
							map[row][col] = '.';
							col -= 1;
						} else {
							map[row][col] = '<';
						}
					}else {
						map[row][col] = '<';
					}

					break;
				case 'R':
					if (col + 1 < width) {
						if (map[row][col + 1] == '.') {
							map[row][col + 1] = '>';
							map[row][col] = '.';
							col += 1;
						} else {
							map[row][col] = '>';
						}
					}else {
						map[row][col] = '>';
					}

					break;
				case 'S':// shoot
					char meet;
					int r = row;
					int c = col;
					switch (map[r][c]) { // 현재 바라보는 방향
					case '^': // 윗방향
						while (true) {
							if (r - 1 < 0 || map[r][c] == '*' || map[r][c] == '#') {
								meet = map[r][c];
								break;
							}
							r -= 1;
						}
						if (meet == '*') {
							map[r][c] = '.';
						}
						break;
					case 'v': // 아래 방향
						while (true) {
							if (r + 1 >= height || map[r][c] == '*' || map[r][c] == '#') {
								meet = map[r][c];
								break;
							}
							r += 1;
						}
						if (meet == '*') {
							map[r][c] = '.';
						}
						break;
					case '<': // 왼쪽방향
						while (true) {
							if (c - 1 < 0 || map[r][c] == '*' || map[r][c] == '#') {
								meet = map[r][c];
								break;
							}
							c -= 1;
						}
						if (meet == '*') {
							map[r][c] = '.';
						}
						break;
					case '>': // 오른쪽 방향
						while (true) {
							if (c + 1 >= width || map[r][c] == '*' || map[r][c] == '#') {
								meet = map[r][c];
								break;
							}
							c += 1;
						}
						if (meet == '*') {
							map[r][c] = '.';
						}
						break;
					}
					break;
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}