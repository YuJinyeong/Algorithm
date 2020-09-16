import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14501 {
	static int N, T[], P[], ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		T = new int[N];
		P = new int[N];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		process(0, 0);
		
		System.out.println(ans);
	}
	
	private static void process(int idx, int tot) {
		if(idx == N) {
			ans = Math.max(ans, tot);
			return;
		}
		
		if(idx + T[idx] > N) {
			process(idx+1, tot);
		}else {
			process(idx+1, tot);
			process(idx+T[idx], tot+P[idx]);
		}
		
	}
}
