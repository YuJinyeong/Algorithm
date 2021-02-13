import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.13460 구슬 탈출 2
public class q13460 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "(" + r + ", " + c + ")";
		}
	}

	static int min = Integer.MAX_VALUE;
	static int N, M;
	static char[][] map;
	static Node R, B, O, NR, NB;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];
		for (int i = 0; i < N; i++)
			map[i] = in.readLine().toCharArray();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					R = new Node(i, j);
				} else if (map[i][j] == 'B') {
					B = new Node(i, j);
				} else if (map[i][j] == 'O') {
					O = new Node(i, j);
				}
			}
		}
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };
		int answer = -1;
		Queue<Node[]> qu = new LinkedList<>();
		Node CNT = new Node(0, -1);
		qu.add(new Node[] { R, B, CNT });
		while (!qu.isEmpty()) {
			Node[] cur = qu.poll(); // 0은 R, 1은 B
			Node R = cur[0];
			Node B = cur[1];

			if (map[R.r][R.c] == 'O' && map[B.r][B.c] == 'O') {
//				System.out.println("두 공이 함께 떨어져서 끝");
				continue;
			}
			if (R.r == O.r && R.c == O.c) {
//				System.out.println("도착!");
				answer = cur[2].r;
				break;
			}
			if (B.r == O.r && B.c == O.c)
				continue;
			if (cur[2].r > 10) {
//				System.out.println(cur[2].r + "이 10이상이라 탈락");
				break;
			}

			// 왼쪽, 오른쪽, 위, 아래로 기울기
			for (int d = 0; d < 4; d++) {
				if (cur[2].c == d)
					continue;
//				if (cur[2].c + d == 1 || cur[2].c + d == 5)
//					continue;
				// 빨간공
				int nr = R.r, nc = R.c;
				while (true) {
					nr += dr[d];
					nc += dc[d];
					if (map[nr][nc] == 'O') {
						NR = new Node(nr, nc);
						break;
					}
					if (map[nr][nc] == '#') {
						NR = new Node(nr -= dr[d], nc -= dc[d]);
						break;
					}
				}

				// 파란공
				nr = B.r;
				nc = B.c;
				while (true) {
					nr += dr[d];
					nc += dc[d];
					if (map[nr][nc] == 'O') {
						NB = new Node(nr, nc);
						break;
					}
					if (map[nr][nc] == '#') {
						NB = new Node(nr -= dr[d], nc -= dc[d]);
						break;
					}
				}

				// 빨간 공이랑 파란 공이랑 겹칠때
				if (NR.r == NB.r && NR.c == NB.c && map[NR.r][NR.c] != 'O') {
					// 누가 먼저 도착했는지 따진다
					int disR = Math.abs(R.r - NR.r) + Math.abs(R.c - NR.c);
					int disB = Math.abs(B.r - NR.r) + Math.abs(B.c - NB.c);
					if (disR > disB)
						NR = new Node(NR.r -= dr[d], NR.c -= dc[d]);
					else
						NB = new Node(NB.r -= dr[d], NB.c -= dc[d]);
				}

//				System.out.println("<< " + (cur[2].r + 1) + " >> " + d);
//				System.out.println("NR: " + NR.toString() + ", NB: " + NB.toString());
				qu.add(new Node[] { NR, NB, new Node(cur[2].r + 1, d) });
			}
		}

		System.out.println(answer);
	}

}
