import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2669 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean[][] map = new boolean[101][101];
		
		int ans = 0;
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = 100 - Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = 100 - Integer.parseInt(st.nextToken());
			
			for(int r=y2; r<y1; r++) {
				for(int c=x1; c<x2; c++) {
					if(!map[r][c]) {
						map[r][c] = true;
						ans++;
					}
				}
			}
		}
		
		System.out.println(ans);
		
		
		
	}
}
