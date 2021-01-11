import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.2644 촌수계산
public class q2644 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int fin = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(in.readLine());
		
		int[] parent = new int[n+1];
		boolean[] check = new boolean[n+1];
		int p=0, c=0;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			parent[c] = p;
		}
		
		int answer = 0;
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {start, 0});
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			check[cur[0]] = true;
			
			if(cur[0] == fin) {
				answer = cur[1];
				break;
			}
			
			if(parent[cur[0]] != 0)
				qu.add(new int[] {parent[cur[0]], cur[1]+1});
			
			for(int i=1; i<=n; i++) {
				if(!check[i] && parent[i]==cur[0]) 
					qu.add(new int[] {i, cur[1]+1});
			}
		}
		
		answer = (answer==0 && start!=fin)? -1: answer;
		System.out.println(answer);
	}
}
