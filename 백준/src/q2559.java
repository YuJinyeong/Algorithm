import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int temp[] = new int[N];
		int sum = 0;
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
			if(i<K) sum+=temp[i];
		}
		
		int max = sum;
		int idx = 0;
		for(int i=K; i<N; i++, idx++) {
			sum -= temp[idx];
			sum += temp[i];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
		
	}
}
