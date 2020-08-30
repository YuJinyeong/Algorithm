package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토2 {

	static class pos {
		int r;
		int c;
		int h;

		public pos(int h, int r, int c) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] box = new int[H][N][M];

		Queue<pos> qu = new LinkedList<>();

		int tomato = 0;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					box[h][i][j] = Integer.parseInt(st.nextToken());
					if (box[h][i][j] == 1)
						qu.add(new pos(h, i, j));
					if(box[h][i][j] == 0)
						tomato++;
				}
			}
		}

		int[] dr = { 0, 0, -1, 1, 0, 0 };
		int[] dc = { 0, 0, 0, 0, -1, 1 };
		int[] dh = { 1, -1, 0, 0, 0, 0 };

		int day = 0;
		while (!qu.isEmpty()) {
			pos cur = qu.poll();
			day = box[cur.h][cur.r][cur.c];

			for (int d = 0; d < 6; d++) {
				int nh = cur.h + dh[d];
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= N || nc >= M)
					continue;

				if (box[nh][nr][nc] == 0) {
					box[nh][nr][nc] = day + 1;
					qu.add(new pos(nh, nr, nc));
					tomato--;
				}
			}
		}
		
		
		System.out.println(tomato == 0 ? day - 1 : - 1);
	}

}
