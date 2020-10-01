import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2606 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int T = Integer.parseInt(in.readLine());
		
		boolean[][] conn = new boolean[N+1][N+1];
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			conn[n1][n2] = true;
			conn[n2][n1] = true;
		}
		
		int cnt = 0;
		Queue<Integer> qu = new LinkedList<>();
		boolean[] check = new boolean[N+1];
		check[1] = true;
		qu.add(1);
		
		while(!qu.isEmpty()) {
			int cur = qu.poll();
			
			for(int i=1; i<=N; i++) {
				if(!check[i] && conn[cur][i]) {
					check[i] = true;
					cnt++;
					qu.add(i);
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
