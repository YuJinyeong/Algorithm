import java.util.Scanner;

public class q15988 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		long[] D = new long[1000001];
		D[0] = 0;
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for(int i=4; i<=1000000; i++) {
			D[i] = (D[i-3] + D[i-2] + D[i-1])%1000000009;
		}
		
		for(int t=0; t<T; t++) {
			System.out.println(D[sc.nextInt()]);
		}
	}

}
