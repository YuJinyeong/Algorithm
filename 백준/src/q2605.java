import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int n[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			n[i] = Integer.parseInt(st.nextToken());
		}
		
		int p[] = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = N - n[i];
			for(int j=0; j<i; j++) {
				if(p[j] <= p[i])
					p[j]--;
			}
		}
		
		int ans[] = new int[N];
		for(int i=0; i<N; i++)
			ans[p[i]-1] = i + 1;
		
		for(int i=0; i<N; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
