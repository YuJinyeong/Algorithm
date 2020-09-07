import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Q.1260 DFS와 BFS
public class q1260 {
	static int N, M, V;
	static int[][] map;
	static boolean[] check;
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		check = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			map[n1][n2] = 1;
			map[n2][n1] = 1;
		}

		sb = new StringBuilder();
		DFS(V, 0);
		BFS(V);
		System.out.println(sb);
	}

	private static void DFS(int V, int cnt) {
		check[V] = true;
		sb.append(V + " ");
		
		if (cnt == N) {
			return;
		}

		for (int i = 1; i < N + 1; i++) {
			if (map[V][i] == 1 && check[i] == false) {
				DFS(i, cnt + 1);
			}
		}
	}

	private static void BFS(int V) {
		sb.append("\n");
		
		Queue<Integer> qu = new LinkedList<>();
		qu.add(V);
		
		while(!qu.isEmpty()) {
			int cur = qu.poll();
			check[cur] = false;
			sb.append(cur + " ");
			
			for(int i=1; i<N+1; i++) {
				if(map[cur][i] == 1 && check[i] == true) {
					qu.add(i);
					check[i] = false;
				}
			}
		}
	}

}
