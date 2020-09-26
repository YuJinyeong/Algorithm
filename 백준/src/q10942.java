import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q10942 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		for(int i=1; i<N+1; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int D[][] = new int[N+1][N+1]; // 0은 홀수, 1은 짝수인 팰린드롬
		
		for(int l=0; l<N; l++) {
			for(int s=0; s+l<=N; s++) {
				int e = s+l;
				
				if(s==e) {
					D[s][e] = 1;
					continue;
				}
				
				if(s+1 == e) {
					if(arr[s]==arr[e])	D[s][e] = 1;
					else D[s][e] = 0;
					continue;
				}
				
				if(arr[s] == arr[e] && D[s+1][e-1]==1)
					D[s][e] = 1;
				
				else
					D[s][e] = 0;
			}
		}
		
		int M = Integer.parseInt(in.readLine());
		int S=0, E=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			sb.append(D[S][E]).append("\n");
		}
		
		System.out.println(sb);
	
	}
}
