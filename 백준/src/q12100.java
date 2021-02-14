import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//Q.12100 2048(easy)
public class q12100 {
	static int max, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > max)
					max = map[i][j];
			}
		}

		dfs(map, 0, max);
		System.out.println(max);

	}

	private static void dfs(int[][] map, int cnt, int block) {
		if (cnt == 5) {
			max = Math.max(max, block);
			return;
		}

		int[][] nxt;
		Stack<Integer> stack;
		Stack<Integer> check;
		// 왼쪽으로 이동
		int num = block;
		nxt = new int[N][N];
		for (int i = 0; i < N; i++) {
			stack = new Stack<>();
			check = new Stack<>();
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != 0) {
					if (!stack.isEmpty() && stack.peek() == map[i][j] && check.peek() == 0) {
						check.push(1);
						stack.push(map[i][j] + stack.pop());
						if (num < stack.peek())
							num = stack.peek();
					} else {
						check.push(0);
						stack.push(map[i][j]);
					}
				}
			}
			int j = stack.size() - 1;
			while (!stack.isEmpty()) {
				nxt[i][j] = stack.pop();
				j--;
			}
		}
//		System.out.println(cnt + "왼쪽 =================");
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(nxt[i]));
//		}
		dfs(nxt, cnt + 1, num);

		// 오른쪽으로 이동
		num = block;
		nxt = new int[N][N];
		for (int i = 0; i < N; i++) {
			stack = new Stack<>();
			check = new Stack<>();
			for (int j = map.length - 1; j >= 0; j--) {
				if (map[i][j] != 0) {
					if (!stack.isEmpty() && stack.peek() == map[i][j] && check.peek() == 0) {
						check.push(1);
						stack.add(map[i][j] + stack.pop());
						if (num < stack.peek())
							num = stack.peek();
					} else {
						check.push(0);
						stack.add(map[i][j]);
					}
				}
			}
			int j = N - stack.size();
			while (!stack.isEmpty()) {
				nxt[i][j] = stack.pop();
				j++;
			}
		}
//		System.out.println(cnt + " 오른쪽 =================");
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(nxt[i]));
//		}
		dfs(nxt, cnt + 1, num);

		// 위로 이동
		num = block;
		nxt = new int[N][N];
		for (int j = 0; j < N; j++) {
			stack = new Stack<>();
			check = new Stack<>();
			for (int i = 0; i < map.length; i++) {
				if (map[i][j] != 0) {
					if (!stack.isEmpty() && stack.peek() == map[i][j] && check.peek() == 0) {
						check.push(1);
						stack.add(map[i][j] + stack.pop());
						if (num < stack.peek())
							num = stack.peek();
					} else {
						check.push(0);
						stack.add(map[i][j]);
					}
				}
			}
			int i = stack.size() - 1;
			while (!stack.isEmpty()) {
				nxt[i][j] = stack.pop();
				i--;
			}
		}
//		System.out.println(cnt + " 위 =================");
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(nxt[i]));
//		}
		dfs(nxt, cnt + 1, num);

		// 아래로 이동
		num = block;
		nxt = new int[N][N];
		for (int j = 0; j < N; j++) {
			stack = new Stack<>();
			check = new Stack<>();
			for (int i = map.length - 1; i >= 0; i--) {
				if (map[i][j] != 0) {
					if (!stack.isEmpty() && stack.peek() == map[i][j] && check.peek() == 0) {
						check.push(1);
						stack.add(map[i][j] + stack.pop());
						if (num < stack.peek())
							num = stack.peek();
					} else {
						check.push(0);
						stack.add(map[i][j]);
					}
				}
			}
			int i = N - stack.size();
			while (!stack.isEmpty()) {
				nxt[i][j] = stack.pop();
				i++;
			}
		}
//		System.out.println(cnt + " 아래 =================");
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(nxt[i]));
//		}
		dfs(nxt, cnt + 1, num);
	}
}
