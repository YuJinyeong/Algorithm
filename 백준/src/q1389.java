import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// Q.1389 케빈 베이컨의 6단계 법칙
public class q1389 {
	static int N;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N][N];
		int[][] list = new int[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(list[i], 987654321);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int p1 = Integer.parseInt(st.nextToken())-1;
			int p2 = Integer.parseInt(st.nextToken())-1;
			list[p1][p2] = 1;
			list[p2][p1] = 1;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(list[j][k] > list[j][i] + list[i][k])
						list[j][k] = list[j][i] + list[i][k];
				}
			}
		}

		int MIN = Integer.MAX_VALUE, MIN_IDX = -1;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				sum += list[i][j];
			}
			if(sum < MIN) {
				MIN = sum;
				MIN_IDX = i;
			}
		}
		
		System.out.println(MIN_IDX + 1);
	}
	
}
