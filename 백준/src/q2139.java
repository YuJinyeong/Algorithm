import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.2139 이친수
public class q2139 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[] Cnt = new long[91];
		Cnt[1] = 1;
		for(int n=2; n<=N; n++) 
			Cnt[n] = Cnt[n-1] + Cnt[n-2];
		System.out.println(Cnt[N]);
	}
}
