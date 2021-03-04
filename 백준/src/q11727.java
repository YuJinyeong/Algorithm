import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.11727 2xn 타일링 2
public class q11727 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] T = new int[1001];
		T[1] = 1;
		T[2] = 3;
		for(int i=3; i<=n; i++) 
			T[i] = (T[i-1] + T[i-2]*2)%10007;
		System.out.println(T[n]);
	}
}
