import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.14940 쉬운 최단거리
public class q14940 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		int[] cur = new int[3];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					map[i][j] = -1;
				}else if(map[i][j] == 2) {
					cur[0] = i;
					cur[1] = j;
					cur[2] = 0;
					map[i][j] = 0;
				}
			}
		}
		
		int dr[] = {-1, 1, 0, 0};
		int dc[] = {0, 0, -1, 1};
		
		Queue<int[]> qu = new LinkedList<>();
		qu.offer(cur);
		while(!qu.isEmpty()) {
			int[] c = qu.poll();
			for(int d=0; d<4; d++) {
				int nr = c[0] + dr[d];
				int nc = c[1] + dc[d];
				
				if(nr<0 || nc<0 || nr>=n || nc>=m || map[nr][nc] != -1)
					continue;
				
				map[nr][nc] = c[2] + 1;
				qu.add(new int[] {nr, nc, map[nr][nc]});
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
