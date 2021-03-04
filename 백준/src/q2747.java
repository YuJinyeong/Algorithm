import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.2747 피보나치 수
public class q2747 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		long[] fibo = new long[46];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2; i<=n; i++) 
			fibo[i] = fibo[i-1] + fibo[i-2];
		System.out.println(fibo[n]);
	}
}
