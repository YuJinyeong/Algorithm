import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.16235 나무 재테크
public class q16235 {
	static int N, M, K, A[][], Map[][], x, y, z;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static PriorityQueue<Tree> trees;
	static Queue<Tree> lives, deads;
	static Tree t;

	static class Tree implements Comparable<Tree> {
		int r, c, age;

		Tree(int x, int y, int z) {
			this.r = x;
			this.c = y;
			this.age = z;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age; // 오름차순
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		trees = new PriorityQueue<>();
		lives = new LinkedList<>();
		deads = new LinkedList<>();

		Map = new int[N+1][N+1];
		A = new int[N+1][N+1]; //
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(Map[i], 5);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			trees.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		for (int k = 0; k < K; k++) {
			spring();
			summer();
			fall();
			winter();
		}

		System.out.println(trees.size());

	}

	private static void spring() {
		// 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
		while (!trees.isEmpty()) {
			t = trees.poll();

			if (Map[t.r][t.c] >= t.age) {
				Map[t.r][t.c] -= t.age;
				lives.add(new Tree(t.r, t.c, t.age + 1));
			} else {
				deads.add(new Tree(t.r, t.c, t.age));
			}
		}
	}

	private static void summer() {
		// 여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
		while (!deads.isEmpty()) {
			t = deads.poll();
			Map[t.r][t.c] += t.age / 2;
		}
	}

	private static void fall() {
		// 가을에는 나무가 번식한다.
		while (!lives.isEmpty()) {
			t = lives.poll();
			if (t.age % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					int nr = t.r + dr[d];
					int nc = t.c + dc[d];

					if (nr < 1 || nc < 1 || nr > N || nc > N)
						continue;

					trees.add(new Tree(nr, nc, 1));
				}
			}
			trees.add(t);
		}
	}

	private static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				Map[i][j] += A[i][j];
			}
		}
	}
}
