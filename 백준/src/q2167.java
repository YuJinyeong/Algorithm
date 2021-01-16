import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.2167 2차원 배열의 합
public class q2167 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][M+1];
		int[][] sum = new int[N+1][M+1];
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int m=1; m<=M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
				sum[n][m] = sum[n][m-1] + arr[n][m];
			}
		}
		
		int K = Integer.parseInt(in.readLine());
		int i=0, j=0, x=0, y=0, result=0;;
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(in.readLine(), " ");
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			result = 0;
			for(int r=i; r<=x; r++) {
				result += sum[r][y] - sum[r][j] + arr[r][j];
			}
			System.out.println(result);
		}
	}
}
