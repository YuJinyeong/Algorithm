import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int S[] = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++)
			S[i] = Integer.parseInt(st.nextToken());
		
		
		int M = Integer.parseInt(br.readLine());
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			boolean female = Integer.parseInt(st.nextToken())==2? true: false;
			int number = Integer.parseInt(st.nextToken());
			if(female) {
				int n = 1;
				S[number] = S[number]==1?0:1;
				while(number-n > 0 && number+n <= N) {
					if(S[number-n]!=S[number+n]) break;
					S[number-n] = S[number-n]==0?1:0;
					S[number+n] = S[number-n];
					n++;
				}
			}else {
				int idx = number;
				while(idx <= N) {
					S[idx] = S[idx]==1?0:1;
					idx += number;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(S[i] + " ");
			if(i%20==0)	System.out.println();
		}
	}
}
