import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2178 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N+2][M+2];
		
		for(int i=1; i<=N; i++) {
			String str = in.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = str.charAt(j-1)-'0';
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {1, 1});
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			if(cur[0]==N && cur[1]==M)
				break;
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				int cnt = map[cur[0]][cur[1]] + 1;
				
				if(map[nr][nc] == 1) {
					map[nr][nc] = cnt;
					qu.add(new int[] {nr, nc});
				}	
			}
		}
		System.out.println(map[N][M]);
	}

}
