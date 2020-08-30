package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int w = 0, h = 0;
		int[][] map;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0)
				break;
			
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
			int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
			
			Queue<int[]> qu = new LinkedList<int[]>();
			int cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1) {
						qu.add(new int[] {i, j});
						cnt++;
						while(!qu.isEmpty()) {
							int[] p = qu.poll();
							for(int d=0; d<8; d++) {
								int nr = p[0] + dr[d];
								int nc = p[1] + dc[d];
								
								// 범위를 벗어나면 탈락
								if(nr<0 || nc<0 || nr>=h || nc>=w)
									continue;
								
								// 바다면 탈락
								if(map[nr][nc] == 0)
									continue;
								
								// 이미 방문한 곳이면 탈락
								if(map[nr][nc] == 2)
									continue;
								
								map[nr][nc] = 2;
								qu.add(new int[] {nr, nc});
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
