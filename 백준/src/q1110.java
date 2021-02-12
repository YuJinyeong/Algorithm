import java.util.Scanner;

//Q.1110 더하기 사이클
public class q1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n = 0;
		int plus = N;
		while(true) {
			int a = plus%10;
			int b = plus/10;
			plus = a * 10 + (a + b) % 10;
			n++;
			System.out.println(plus);
			if(plus == N)
				break;
		}
		System.out.println(n);
	}
}
