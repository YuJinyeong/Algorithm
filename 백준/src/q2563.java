import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[100][100];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int h=0; h<10; h++) {
				for(int w=0; w<10; w++) {
					if(board[y+h][x+w] == 0) {
						board[y+h][x+w] = 1;
					}else	cnt++;
				}
			}
		}
		System.out.println(N*100 - cnt);
		
	}
}
