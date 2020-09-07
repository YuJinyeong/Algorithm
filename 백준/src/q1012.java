import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Q.1012 유기농 배추
public class q1012 {
	static int[][] map;

	static class Node {
		private int r;
		private int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public int getR() {
			return r;
		}

		public void setR(int r) {
			this.r = r;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int T = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			ans = 0;
			
			map = new int[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				map[u][v] = 1;
			}

			Queue<Node> qu;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						ans++;
						qu = new LinkedList<>();
						qu.add(new Node(i, j));
						while (!qu.isEmpty()) {
							Node n = qu.poll();
							for (int d = 0; d < 4; d++) {
								int nr = n.r + dr[d];
								int nc = n.c + dc[d];
								
								if (nr < 0 || nc < 0 || nr >= M || nc >= N)
									continue;
								
								if (map[nr][nc] == 1) {
									qu.add(new Node(nr, nc));
									map[nr][nc] = 0;
								}
							}
						}
					}
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb.toString());
	}

}
