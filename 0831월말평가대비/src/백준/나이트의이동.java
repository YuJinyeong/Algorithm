package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동 {
	static int[] dr = {1, -1, 2, -2, 2, -2, 1, -1};
	static int[] dc = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[][] board;
	static int[] start = new int[3];
	static int[] fin = new int[3];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			
			st = new StringTokenizer(br.readLine(), " ");
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			start[2] = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			fin[0] = Integer.parseInt(st.nextToken());
			fin[1] = Integer.parseInt(st.nextToken());
			fin[2] = 0;
			
			Queue<int[]> qu = new LinkedList<int[]>();
			qu.add(start);
			int cnt = 0;
			
			L: while(!qu.isEmpty()) {
				int[] cur = qu.poll();
				
				// 목적지에 도착했을 때
				if(cur[0] == fin[0] && cur[1] == fin[1]) {
					cnt = cur[2];
					break;
				}
				
				board[cur[0]][cur[1]] = -1;
				
				for(int d=0; d<8; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					int ncnt = cur[2] + 1;
					
					// 범위를 벗어나면 탈락
					if(nr<0 || nc<0 || nr>=N || nc>=N)
						continue;
					
					// 이미 방문한 곳이면 탈락
					if(board[nr][nc] == -1)
						continue;
					
					// 목적지에 도착하면
					if(board[nr][nc] == 1) {
						cnt = ncnt;
						break L;
					}
					
					board[nr][nc] = -1;
					qu.add(new int[] {nr, nc, ncnt});
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		
		
	}

}
