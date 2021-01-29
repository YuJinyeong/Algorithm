import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.17144 미세먼지 안녕!
public class q17144 {
	static int R, C, T, A[][], nr, nc;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<int[]> dusts = new LinkedList<>();
	static Queue<int[]> changed = new LinkedList<>();
	static int[] cleaner = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		A = new int[R][C];
		for (int r = 0, idx = -1; r < R; r++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int c = 0; c < C; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
				if (A[r][c] == -1) {
					cleaner[++idx] = r;
				} else if (A[r][c] != 0)
					dusts.offer(new int[] { r, c, A[r][c] });
			}
		}
		
		for (int t = 0; t < T; t++) {
			spread();
			purify();
			//미세먼지 다시 체크 후 큐에 추가
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(A[r][c] > 0)
						dusts.offer(new int[] {r, c, A[r][c]});
				}
			}
		}

		System.out.println(check());
	}
//
//	private static void print() {
//		System.out.println("++++++++++++++++++++");
//		for (int r = 0; r < R; r++) {
//			for (int c = 0; c < C; c++) {
//				System.out.print(A[r][c] + " ");
//			}
//			System.out.println();
//		}
//	}

	private static int check() {
		int answer = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(A[r][c] > 0)
					answer += A[r][c];
			}
		}
		return answer;
	}

	private static void purify() {
		// 위쪽 공기 청정기의 바람은 반시계방향으로 순환한다
		int[] up = {3, 0, 2, 1};
		nr = cleaner[0];
		nc = 0;
		int dust = 0;
		int tmp = 0;
		for (int d = 0; d < 4;) {
			// 순환이 끝나면 종료
			if (nr == cleaner[0] && nc == 0 && d > 0)
				break;

			// 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
			// 공기청정기로 들어간 미세먼지는 모두 정화된다.
			nr += dr[up[d]];
			nc += dc[up[d]];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
				nr -= dr[up[d]];
				nc -= dc[up[d]];
				d++;
				continue;
			}

			tmp = A[nr][nc];
			A[nr][nc] = dust;
			dust = tmp;
		}

		// 아래쪽 공기 청정기의 바람은 시계방향으로 순환한다.
		int[] down = {3, 1, 2, 0};
		nr = cleaner[1];
		nc = 0;
		dust = 0; //한 칸 전의 값
		tmp = 0;
		for (int d = 0; d < 4;) {
			// 순환이 끝나면 종료
			if (nr == cleaner[1] && nc == 0 && d > 0)
				break;

			// 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
			// 공기청정기로 들어간 미세먼지는 모두 정화된다.
			nr += dr[down[d]];
			nc += dc[down[d]];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
				nr -= dr[down[d]];
				nc -= dc[down[d]];
				d++;
				continue;
			}

			tmp = A[nr][nc];
			A[nr][nc] = dust;
			dust = tmp;
		}
		
		A[cleaner[0]][0] = -1;
		A[cleaner[1]][0] = -1;
	}

	private static void spread() {
		while (!dusts.isEmpty()) {
			int[] cur = dusts.poll();
			int total = cur[2];

			int cnt = spreadCheck(cur[0], cur[1], cur[2]);
			if(cnt == -1) changed.offer(cur);
			else {
				for (int d = 0; d < 4; d++) {
					nr = cur[0] + dr[d];
					nc = cur[1] + dc[d];
	
					// 칸이 없으면 확산하지 않음
					if (nr < 0 || nc < 0 || nr >= R || nc >= C)
						continue;
	
					// 공기청정기가 있으면 확산하지 않음
					if (nc == 0 && (nr == cleaner[0] || nr == cleaner[1]))
						continue;
					
					changed.offer(new int[] {nr, nc, total/5});
				}
				changed.offer(new int[] {cur[0], cur[1], -(total/5)*cnt});
			}
		}
		
		//미세먼지 확산된 이후의 갑 반영
		while(!changed.isEmpty()) {
			int cur[] = changed.poll();
			A[cur[0]][cur[1]] += cur[2];
		}
	}

	private static int spreadCheck(int r, int c, int dust) {
		int tot = 0;
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];

			// 칸이 없으면 확산하지 않음
			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;

			// 공기청정기가 있으면 확산하지 않음
			if (nc == 0 && (nr == cleaner[0] || nr == cleaner[1]))
				continue;

			cnt++;
			tot += dust/5;
			if(tot > dust)
				return -1;
		}
		return cnt;
	}
}
