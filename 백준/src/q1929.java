import java.util.Scanner;

public class q1929 {
	static boolean[] isNotDecimal = new boolean[1000001];
	static int M, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 M = sc.nextInt();
		 N = sc.nextInt();
		 
		 decimalCheck();
		 for(int i=M; i<=N; i++) {
			 if(!isNotDecimal[i])
				 System.out.println(i);
		 }
	}
	
	public static void decimalCheck() {
		isNotDecimal[0] = true;
		isNotDecimal[1] = true;
		for(int i=2; i<N+1; i++) {
			if(!isNotDecimal[i]) {
				int num = i;
				while(num <= N) {
					isNotDecimal[num] = true;
					num += i;
				}
				isNotDecimal[i] = false;
			}
		}
	}
}
