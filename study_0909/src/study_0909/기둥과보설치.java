package study_0909;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기둥과보설치 {

	public static void main(String[] args) {
		int n = 5;
//		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 }, { 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] ans = solution(n, build_frame);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(Arrays.toString(ans[i]));
		}
	}

	static boolean[][][] map;
	static int N;
	static int[] dr = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[] dc = { -1, -1, -1, 0, 0, 1, 1, 1 };

	static int[][] solution(int n, int[][] build_frame) {
		System.out.println("solution 호출 " + build_frame.length);
		int[][] answer;
		Queue<int[]> qu;

		map = new boolean[n + 1][n + 1][2];
		N = n;

		int c, r, a, cnt = 0;

		for (int i = 0; i < build_frame.length; i++) {
			c = build_frame[i][0];
			r = n - build_frame[i][1];
			a = build_frame[i][2];

			if (build_frame[i][3] == 1) { // 추가
				System.out.println("추가");
				if (build_frame[i][2] == 0) { // 기둥 추가
					if (checkColumn(c, r)) {
						System.out.println(r + ", " + c + " 기둥 추가");
						map[r][c][0] = true;
						cnt++;
					}
				} else {
					if (checkBeam(c, r)) {
						map[r][c][1] = true;
						System.out.println(r + ", " + c + " 보 추가");
						cnt++;
					}
				}
			} else { // 삭제
				qu = new LinkedList<int[]>();
				map[r][c][a] = false;
				System.out.println(r + ", " + c + " 삭제 시도");
				cnt--;
				qu.add(new int[] { c, r });

				System.out.println("주변 탐색 시작~~");
				
				// 주변 탐색해서 영향을 받는 게 있는지 확인
				for (int d = 0; d < 8; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nc < 0 || nr > N || nc > N)
						continue;

					if ((map[nr][nc][0] && !checkColumn(nc, nr)) || (map[nr][nc][1] && !checkBeam(nc, nr))) {
						System.out.println("삭제 실패");
						map[r][c][a] = true;
						cnt++;
						break;
					}
				}
				
//				out: while (!qu.isEmpty()) {
//					int[] cur = qu.poll();
//					int curX = cur[0];
//					int curY = cur[1];
//					System.out.println("(" + curY + ", " + curX + ")");
//
//					// 주변 탐색해서 영향을 받는 게 있는지 확인
//					for (int d = 0; d < 8; d++) {
//						int nr = curY + dr[d];
//						int nc = curX + dc[d];
//
//						if (nr < 0 || nc < 0 || nr > N || nc > N)
//							continue;
//
//						if (map[nr][nc][0] && !checkColumn(nr, nc)) {
//							System.out.println("삭제 실패");
//							map[y][x][a] = true;
//							cnt++;
//							break out;
//						}
//						if (map[nr][nc][1] && !checkBeam(nr, nc)) {
//							System.out.println("삭제 실패");
//							map[y][x][a] = true;
//							cnt++;
//							break out;
//						}
//					}
//				}

			}
		}

		System.out.println(cnt);
		
		answer = new int[cnt][3];
		int idx = 0;
		for (int i = 0; i < N + 1; i++) {
			for (int j = N; j >=0; j--) {
				if (map[j][i][0]) {
					answer[idx++] = new int[] { i, N-j, 0 };
				}
				if (map[j][i][1]) {
					answer[idx++] = new int[] { i, N-j, 1 };
				}
			}
		}
		return answer;
	}

	private static boolean checkBeam(int c, int r) {
		System.out.println("checkBeam(" + r + ", " + c + ")");
		if(c==N || r==N) return false;
		if ((r < N && map[r + 1][c][0]) || (r < N && c < N && map[r + 1][c + 1][0]))
			return true;
		if (c > 0 && c < N && map[r][c - 1][1] && map[r][c + 1][1])
			return true;
		System.out.println("보를 놓을 수 없음");
		return false;
	}

	private static boolean checkColumn(int c, int r) {
		if(r == 0) return false; 	
		System.out.println("checkColumn(" + r + ", " + c + ")");
		if (r == N || map[r][c][1] || (c > 0 && map[r][c - 1][1]) || (r < N && map[r + 1][c][0]))
			return true;
		System.out.println("기둥을 놓을 수 없음");
		return false;
	}

}
