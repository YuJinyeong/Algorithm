import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.1707 이분 그래프
public class q1707 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			LinkedList<Integer>[] graph = new LinkedList[V];
			for(int i=0; i<V; i++)
				graph[i] = new LinkedList<>();
			
			for(int e=0; e<E; e++) {
				st = new StringTokenizer(in.readLine(), " ");
				int v1 = Integer.parseInt(st.nextToken()) - 1;
				int v2 = Integer.parseInt(st.nextToken()) - 1;
				graph[v1].add(v2);
				graph[v2].add(v1);
			}

			Queue<Integer> qu = new LinkedList<>();
			int[] check = new int[V];
			String answer = "YES";
			out: for(int i=0; i<V; i++) {
				if(check[i] != 0) continue;
				qu.offer(i);
				check[i] = 1;
				
				while(!qu.isEmpty()) {
					int cur = qu.poll();
					
					for(int nxt : graph[cur]) {
						if(check[nxt] == 0) {
							qu.offer(nxt);
							check[nxt] = check[cur]*-1;
						}else if(check[nxt] == check[cur]) {
							answer = "NO";
							break out;
						}
					}
				}
			}
			System.out.println(answer);
			
		}
		
		
		
		
	}
}
