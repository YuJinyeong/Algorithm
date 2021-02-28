import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.2638 치즈
public class q2638 {
	static class Node{
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		int cheese = 0, time = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese++;
			}
		}
		
		Queue<Node> air = new LinkedList<>();
		air.offer(new Node(0, 0));
		while(cheese > 0) {
			int size = air.size();
			for(int i=0; i<size; i++) {
				Node cur = air.poll();
				map[cur.r][cur.c] = 10;
				
				air.offer(cur);
			}
			
			while(!air.isEmpty()) {
				Node cur = air.poll();
				
				for(int d=0; d<4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					if(nr<0 || nc<0 || nr>=N || nc>=M || map[nr][nc] != 0)
						continue;
					
					air.add(new Node(nr, nc));
					map[nr][nc] = 10;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=1; j<M; j++) {
					if(map[i][j] != 1) continue;
					int sum = 0;
					for(int d=0; d<4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
						sum += map[nr][nc];
					}
					if(sum >= 20)	air.offer(new Node(i, j));
				}
			}
			
			cheese -= air.size();
			time++;
		}
		System.out.println(time);

	}
}
