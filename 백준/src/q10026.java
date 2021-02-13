import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//Q.10026 적록색약
public class q10026 {
	static class Node{
		int r, c;
		Node(int r, int c){
			this.r =r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		char[][] map = new char[N][];
		for(int i=0; i<N; i++)
			map[i] = in.readLine().toCharArray();
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int num1 = 0;
		boolean[][] check = new boolean[N][N];
		Queue<Node> qu;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!check[i][j]) {
					num1++;
					check[i][j] = true;
					qu = new LinkedList<>();
					qu.add(new Node(i, j));
					
					while(!qu.isEmpty()) {
						Node cur = qu.poll();
						
						for(int d=0; d<4; d++) {
							int nr = cur.r + dr[d];
							int nc = cur.c + dc[d];
							
							if(nr<0 || nc<0 || nr>=N || nc>=N || check[nr][nc] || map[nr][nc]!=map[cur.r][cur.c])
								continue;
							
							check[nr][nc] = true;
							qu.add(new Node(nr, nc));
						}
					}
				}
			}
		}
		
		int num2 = 0;
		check = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!check[i][j]) {
					num2++;
					check[i][j] = true;
					qu = new LinkedList<>();
					qu.add(new Node(i, j));
					
					while(!qu.isEmpty()) {
						Node cur = qu.poll();
						
						for(int d=0; d<4; d++) {
							int nr = cur.r + dr[d];
							int nc = cur.c + dc[d];
							
							if(nr<0 || nc<0 || nr>=N || nc>=N || check[nr][nc])
								continue;
							
							if(map[nr][nc] == 'B' && map[cur.r][cur.c] != 'B')
								continue;
							
							if(map[nr][nc] != 'B' && map[cur.r][cur.c] == 'B')
								continue;
							
							check[nr][nc] = true;
							qu.add(new Node(nr, nc));
						}
					}
				}
			}
		}
		
		System.out.println(num1 + " " + num2);
	}
}
