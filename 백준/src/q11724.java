import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Q.11724 연결 요소의 개수
public class q11724 {
	static int[] parent;
	static int[] rank;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		rank = new int[N + 1];

		for(int i=1; i<N+1; i++)
			parent[i] = i;
		
		int u, v;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			union(u, v);
		}

		for(int i=1; i<N+1; i++) {
			if(i == parent[i])
				ans++;
		}
		
		System.out.println(ans);
	}

	static int find(int x) {
		if (x == parent[x])
			return x;

		parent[x] = find(parent[x]);
		return find(parent[x]);
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (rank[px] > rank[py]) 
			parent[px] = py;
		else if (rank[px] < rank[py]) 
			parent[px] = py;
		else {
			parent[px] = py;
			rank[py]++;
		}

	}

}
