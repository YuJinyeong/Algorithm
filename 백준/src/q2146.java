import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.2146 다리 만들기
public class q2146 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) map[i][j] = -1;
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		//섬 탐색
		int cnt = 1;
		boolean[][] check = new boolean[N][N];
		Queue<int[]> qu;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == -1) {
					 qu = new LinkedList<>();
					 check[i][j] = true;
					 map[i][j] = cnt;
					 qu.add(new int[] {i, j});
					 while(!qu.isEmpty()) {
						 int[] cur = qu.poll();
						 
						 for(int d=0; d<4; d++) {
							 int nr = cur[0] + dr[d];
							 int nc = cur[1] + dc[d];
							 
							 //지도를 벗어나거나 바다이거나 이미 방문한 곳이면 탈락
							 if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc] == 0 || check[nr][nc])
								 continue;
							 
							 map[nr][nc] = cnt;
							 check[nr][nc] = true;
							 qu.add(new int[] {nr, nc});
						 }
					 }
					 cnt++;
				}
			}
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		int min = Integer.MAX_VALUE;
		//섬 사이에 최단거리 다리 놓기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					int num = map[i][j];
					check = new boolean[N][N];
					qu = new LinkedList<>();
					check[i][j] = true;
					qu.add(new int[] {i, j, 0});
					
					out: while(!qu.isEmpty()) {
						 int[] cur = qu.poll();
						 
						 if(cur[2] >= min) continue;
						 
						 for(int d=0; d<4; d++) {
							 int nr = cur[0] + dr[d];
							 int nc = cur[1] + dc[d];
							 
							 //지도를 벗어나거나 이미 방문한 곳이면 탈락
							 if(nr<0 || nc<0 || nr>=N || nc>=N || check[nr][nc])
								 continue;
							 
							 //바다를 만나면 다리를 놓기 시작
							 if(map[nr][nc] == 0) {
								 check[nr][nc] = true;
								 qu.add(new int[] {nr, nc, cur[2]+1});
								 continue;
							 }
							 
							 //새로운 섬을 만나면 끝
							 if(map[nr][nc] != num) {
//								 System.out.println(num + " : " + cur[2]);
								 min = Math.min(min, cur[2]);
								 break out;
							 }
							 
							 check[nr][nc] = true;
							 qu.add(new int[] {nr, nc, cur[2]});
						 }
					 }
				}
				
			}
		}
		
		System.out.println(min);
	}
}
