package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Q.1974 스도쿠 검증
public class q1974 {

	static int SIZE = 9;
	static int[][] sdoku;
	static int[] horizontal;
	static int[] vertical;
	static int[][] box;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int Answer = 1;
			boolean flag = true;
			
			sdoku = new int[SIZE][SIZE];
			horizontal = new int[SIZE];
			vertical = new int[SIZE];
			box = new int[SIZE / 3][SIZE / 3];

			for (int i = 0; i < SIZE; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int j = 0;
				while (st.hasMoreTokens()) {
					int n = Integer.parseInt(st.nextToken());
					sdoku[i][j] = n;

					if (flag) {
						horizontal[i] += n; // 가로 한 줄 합
						vertical[j] += n; // 세로 한 줄 합
						box[i / 3][j / 3] += n; // 3X3 상자 합

						// 가로 검증
						if (j == SIZE - 1) {
							if (horizontal[i] != 45) {
								Answer = 0;
								flag = false;
							}
						}

						// 세로 검증
						if (i == SIZE - 1) {
							if (vertical[j] != 45) {
								Answer = 0;
								flag = false;
							}
						}

						// 박스 검증
						if (i % 3 == 2 && j % 3 == 2) {
							if (box[i / 3][j / 3] != 45) {
								Answer = 0;
								flag = false;
							}
						}
					}

					j++;
				}
			}
			System.out.println("#" + tc + " " + Answer);
		}
	}

}
