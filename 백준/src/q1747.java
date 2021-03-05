import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.1747 소수&팰린드롬
public class q1747 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int answer = 0;
		while(true) {
			if(isPrime(N) && isPal(Integer.toString(N))) {
				answer = N;
				break;
			}else N++;
		}
		System.out.println(answer);
	}
	
	static boolean isPrime(int a) {
		if(a==1) return false;
		int n = (int) Math.sqrt(a);
		for(int i=2; i<=n; i++) {
			if(a%i == 0)
				return false;
		}
		return true;
	}
	
	static boolean isPal(String str) {
		if(new StringBuffer(str).reverse().toString().equals(str))
			return true;
		else
			return false;
	}
}
