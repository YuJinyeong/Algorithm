import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q2667 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		int num = 0;
		boolean[][] check = new boolean[N][N];
		
		int dr[] = {-1, 1, 0, 0};
		int dc[] = {0, 0, -1, 1};
		
		Queue<int[]> qu = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] > 0 && !check[i][j]) {
					check[i][j] = true;
					qu.add(new int[] {i, j});
					map[i][j] = ++num;
					while(!qu.isEmpty()) {
						int cur[] = qu.poll();
						
						for(int d=0; d<4; d++) {
							int nr = cur[0] + dr[d];
							int nc = cur[1] + dc[d];
							
							if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc]==0 || check[nr][nc])
								continue;
							
							check[nr][nc] = true;
							map[nr][nc] = num;
							qu.add(new int[] {nr, nc});
						}
					}
				}
			}
		}
		

		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		int[] ans = new int[num];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]>0) {
					ans[map[i][j]-1]++;
				}
			}
		}
		Arrays.sort(ans);
		System.out.println(num);
		for(int i=0; i<num; i++) {
			System.out.println(ans[i]);
		}
	}
}
