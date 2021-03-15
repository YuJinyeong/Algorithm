import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.2436 공약수
public class q2436 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int gcd = Integer.parseInt(st.nextToken());
		int lcm = Integer.parseInt(st.nextToken());
		int A=0, B=0, curA=0, curB=0;
		long mul = (long)gcd*(long)lcm;
		for(int i=gcd; i<=Math.sqrt(mul); i+=gcd) {
			if(mul%i != 0) continue;
			curA = (int)i;
			curB = (int)(mul/i);
			int tmp = getGcd(curA, curB);
			if(tmp!=gcd || mul/(long)tmp!=lcm) continue;
			if(A+B==0 || curA+curB < A+B) {
				A = i;
				B = (int)(mul/i);
			}
		}
		System.out.println(A + " " + B);
	}

	private static int getGcd(int i, int j) {
		if(i%j == 0)
			return j;
		return getGcd(j, i%j);
	}
}
