import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15683 {
	static int N, M, map[][], total, answer;
	static int[] dr = { -1, 1, 0, 0 }; //상, 하, 좌, 우
	static int[] dc = { 0, 0, -1, 1 };
	static CCTV[] cctvs = new CCTV[8];
	
	static class CCTV{
		int r, c, t;
		CCTV(int r, int c, int t){
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		total = 0;
		answer = N*M;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m]!=0 && map[n][m]!=6) cctvs[total++] = new CCTV(n, m, map[n][m]);
			}
		}
	
		go(0);
		
		System.out.println(answer);
	}
	
	static int[][] sel4 = {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}};
	static int[][] sel3 = {{0, 2}, {0, 3}, {1, 2}, {1, 3}};
	static int[][] sel2 = {{0, 1}, {2, 3}};
	
	private static void go(int i) {
		if(i == total) {
			answer = Math.min(answer, count());
			return;
		}
		
		CCTV cur = cctvs[i];
		
		if(cur.t == 5) {
			for(int d=0; d<4; d++) {
				looking(cur.r, cur.c, d);
			}
			go(i+1);
		}
		
		else if(cur.t == 4) {
			for(int n=0; n<sel4.length; n++) {
				int[] dir = sel4[n];
				for(int d=0; d<dir.length; d++) {
					looking(cur.r, cur.c, dir[d]);
				}
				go(i+1);
				for(int d=0; d<dir.length; d++) {
					returning(cur.r, cur.c, dir[d]);
				}
			}
		}
		
		else if(cur.t == 3) {
			for(int n=0; n<sel3.length; n++) {
				int[] dir = sel3[n];
				for(int d=0; d<dir.length; d++) {
					looking(cur.r, cur.c, dir[d]);
				}
				go(i+1);
				for(int d=0; d<dir.length; d++) {
					returning(cur.r, cur.c, dir[d]);
				}
			}
		}
		
		else if(cur.t == 2) {
			for(int n=0; n<sel2.length; n++) {
				int[] dir = sel2[n];
				for(int d=0; d<dir.length; d++) {
					looking(cur.r, cur.c, dir[d]);
				}
				go(i+1);
				for(int d=0; d<dir.length; d++) {
					returning(cur.r, cur.c, dir[d]);
				}
			}
		}
		
		else if(cur.t == 1) {
			for(int d=0; d<4; d++) {
				looking(cur.r, cur.c, d);
				go(i+1);
				returning(cur.r, cur.c, d);
			}
		}
		
	}

	private static void looking(int r, int c, int d) {
//		System.out.println("looking(" + r + ", " + c + ", " + d + ")");
		while(true) {
			r += dr[d];
			c += dc[d];
			
			if(r<0 || c<0 || r>=N || c>=M || map[r][c] == 6)
				break;
			
			map[r][c] += 7;
		}
	}
	
	private static void returning(int r, int c, int d) {
		while(true) {
			r += dr[d];
			c += dc[d];

			if(r<0 || c<0 || r>=N || c>=M || map[r][c] == 6)
				break;
			
			map[r][c] -= 7;
		}
	}

	private static int count() {
		int cnt = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(map[n][m] == 0) cnt++;
			}
		}
		return cnt;
	}

	
	
}
