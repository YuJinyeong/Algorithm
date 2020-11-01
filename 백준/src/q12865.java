import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q12865 {
	public static void main(String[] args) throws IOException {
		int N, K;
		int[][] dp;
		int[] W, V;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		W = new int[N+1];
		V = new int[N+1];
		
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			W[n] = Integer.parseInt(st.nextToken());
			V[n] = Integer.parseInt(st.nextToken());
		}
		
		for(int n=1; n<=N; n++) {
			for(int k=0; k<=K; k++) {
				if(k < W[n]) {
					dp[n][k] = dp[n-1][k];
				}else {
					dp[n][k] = Math.max(dp[n-1][k-W[n]]+V[n], dp[n-1][k]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}
}
