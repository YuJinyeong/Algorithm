import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2589 {
	static int hei, wid;
	static boolean[][] check;
	static char[][] map;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		hei = Integer.parseInt(st.nextToken());
		wid = Integer.parseInt(st.nextToken());
		
		map = new char[hei][];
		for(int i=0; i<hei; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		int res=0;
		for(int i=0; i<hei; i++) {
			for(int j=0; j<wid; j++) {
				if(map[i][j]=='L') {
					res = Math.max(res, go(i, j));					
				}
			}
		}
		
		System.out.println(res);
		
	}

	private static int go(int r, int c) {
		check = new boolean[hei][wid];
		int res = 0;
		
		Queue<int[]> qu = new LinkedList<>();
		check[r][c] = true;
		qu.add(new int[] {r, c, 0});
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			res = Math.max(res, cur[2]);
//			System.out.print("(" + cur[0] + ", " + cur[1] + "), ");
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				int nd = res + 1;
				
				if(nr<0 || nc<0 || nr>=hei || nc>=wid || map[nr][nc]=='W' || check[nr][nc])
					continue;

				check[nr][nc] = true;
				qu.add(new int[] {nr, nc, nd});
			}
		}
		
//		System.out.println("(" + r + ", " + c + ") => " + res);
		return res;
	}
	
}
