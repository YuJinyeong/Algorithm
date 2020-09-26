import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q10163 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] board = new int[101][101];
		int N = Integer.parseInt(in.readLine());
		int[] areas = new int[N+1];
		
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int r = 100 - Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(board[r-i][c+j] != 0)
						areas[board[r-i][c+j]]--;
					board[r-i][c+j] = n;
					areas[n]++;
				}
			}
		}
		
		for(int i=1; i<=N; i++)
			System.out.println(areas[i]);
		
	}

}
