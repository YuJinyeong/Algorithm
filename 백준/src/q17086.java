import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.17086 아기 상어 2
public class q17086 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] dis = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
		int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
		
		int answer = 0;
		Queue<int[]> sharks = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					dis[i][j] = 1;
					sharks.add(new int[] {i, j, 0});
				}
			}
		}
		
		while(!sharks.isEmpty()) {
			int[] cur = sharks.poll();
			
			for(int d=0; d<8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M || dis[nr][nc] != 0)
					continue;
				
				dis[nr][nc] = cur[2] + 1;
				sharks.add(new int[] {nr, nc, dis[nr][nc]});
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				answer = Math.max(answer, dis[i][j]);
			}
		}
		
		System.out.println(answer);
	}
}
