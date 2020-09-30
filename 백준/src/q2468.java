import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2468 {
	static int N, map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		int[] height = new int[101];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				height[map[i][j]]++;
			}
		}
		
		int res=0, max=1;
		for(int i=1; i<101; i++) {
			if(height[i]>0) {
				res = process(i);
				max = Math.max(res, max);
			}
		}
		
		System.out.println(max);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static int process(int height) {
		Queue<int[]> qu = new LinkedList<>();
		boolean check[][] = new boolean[N][N];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] > height && !check[i][j]) {
					check[i][j] = true;
					qu.add(new int[] {i, j});
					
					while(!qu.isEmpty()) {
						int[] cur = qu.poll();
						for(int d=0; d<4; d++) {
							int nr = cur[0] + dr[d];
							int nc = cur[1] + dc[d];
							
							if(nr<0 || nc<0 || nr>=N || nc>=N || check[nr][nc] || map[nr][nc]<=height)
								continue;
							
							check[nr][nc] = true;
							qu.add(new int[] {nr, nc});
						}
					}
					
					cnt++;
				}	
			}
		}
		
		return cnt;
	}
}
