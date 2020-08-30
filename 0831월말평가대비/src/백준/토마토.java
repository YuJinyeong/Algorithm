package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

	static class pos{
		int r;
		int c;
		public pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] box = new int[N][M];

		Queue<pos> qu = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1)
					qu.add(new pos(i, j));
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!qu.isEmpty()) {
			pos cur = qu.poll();
			int day = box[cur.r][cur.c];

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (box[nr][nc] == 0) {
					box[nr][nc] = day + 1;
					qu.add(new pos(nr, nc));
				}
			}
		}
		
		int ans = 0;
		out: for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ans = Math.max(ans, box[i][j]);
				if(box[i][j] == 0) {
					ans = -1;
					break out;
				}
			}
		}
		System.out.println(ans==-1? -1 : ans - 1);
	}

}
