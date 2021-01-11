import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.2573 빙산
public class q2573 {
	static class Node {
		int r, c, v;

		Node(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}

	static int R, C, map[][], nr, nc, answer;
	static boolean[][] check;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static Queue<Node> qu, linked;
	static Node std = new Node(-1, -1, -1);

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		qu = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] != 0)
					qu.add(new Node(r, c, map[r][c]));
			}
		}
		qu.add(std);

		answer = 1;
		while (!qu.isEmpty()) {
			Node n = qu.poll();
			
			if (n.r == -1) {
				if (qu.isEmpty() || qu.peek().r==-1) {
					answer = 0;
					break;
				}
				
				n = qu.poll();
				qu.add(std);
				
				int cnt = 0;
				while (n.r != -1) {
					map[n.r][n.c] = n.v;
					if (n.v != 0) {
						qu.add(n);
						cnt++;
					}
					n = qu.poll();
				}

				if (isDivided(cnt)) {
					break;
				}

				answer++;
				qu.add(std);
				n = qu.poll();

			}

			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				nr = n.r + dr[d];
				nc = n.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;

				if (map[nr][nc] == 0)
					cnt++;
			}

			if (n.v > cnt)
				qu.add(new Node(n.r, n.c, n.v - cnt));
			else
				qu.add(new Node(n.r, n.c, 0));

		}

		System.out.println(answer);

	}

	private static boolean isDivided(int cnt) {
		check = new boolean[R][C];
		linked = new LinkedList<>();

		out: for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] != 0) {
					check[r][c] = true;
					cnt--;
					linked.add(new Node(r, c, map[r][c]));
					break out;
				}
			}
		}

		Node n = null;
		while (!linked.isEmpty()) {
			n = linked.poll();
			
			for (int d = 0; d < 4; d++) {
				nr = n.r + dr[d];
				nc = n.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == 0 || check[nr][nc])
					continue;

				cnt--;
				check[nr][nc] = true;
				linked.add(new Node(nr, nc, map[nr][nc]));
			}
		}
		
		return cnt == 0 ? false: true;
	}

}
