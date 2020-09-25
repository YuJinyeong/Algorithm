import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q10157 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine());
		int N = 0;
		
		if(K > R*C) {
			System.out.println(0);
			return;
		}
		
		int[][] map = new int[R+2][C+2];
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		int d = 0, ent = 1, r = R, c = 1;
		map[r][c] = 1;
		while(ent != K) {
			d %= 4;
			r += dr[d];
			c += dc[d];
			if(r<1 || c<1 || r>R || c>C || map[r][c]!=0) {
				r -= dr[d];
				c -= dc[d];
				d++;
			}
			else map[r][c] = ++ent;
		}
		
		System.out.println(c + " " + (R + 1 - r));
		
	}

}
