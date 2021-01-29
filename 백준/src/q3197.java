import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.3197 백조의 호수
public class q3197 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}

		Queue<Node> toSwans = new LinkedList<>();
		Node[] swans = new Node[2];
		boolean[][] check = new boolean[R][C];
		int idx = 0;
		Queue<Node> water = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 'X') {
					water.offer(new Node(i, j));
				}
				if (map[i][j] == 'L') {
					swans[idx] = new Node(i, j);
					idx++;
				}
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int day = 0;
		boolean find = false;

		// 첫번째 백조를 출발점에 놓고 출발
		check[swans[0].r][swans[0].c] = true;
		toSwans.offer(swans[0]);

		while (!find) {
			day++;

			// 주변에 녹일 얼음이 있나 확인
			int size = water.size();
			for(int i=0; i<size; i++) {
				Node cur = water.poll();

				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];

					if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == 'X') {
						map[nr][nc] = '.';
						water.add(new Node(nr, nc));
					}
				}
			}

			// 백조끼리 만날 수 있나 확인
			Queue<Node> next = new LinkedList<>(); // 다음에 백조 탐색을 시작할 지점
			while (!toSwans.isEmpty()) {
				Node cur = toSwans.poll();

				// 또 다른 백조를 만나면 종료
				if (cur.r == swans[1].r && cur.c == swans[1].c) {
					find = true;
					break;
				}

				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C || check[nr][nc])
						continue;

					check[nr][nc] = true;
					
					if (map[nr][nc] == 'X') {
						next.offer(new Node(nr, nc));
						continue;
					}
					
					toSwans.offer(new Node(nr, nc));
				}
			}
			toSwans = next;
		}

		System.out.println(day);

	}
}
