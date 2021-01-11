import java.util.Scanner;

//Q.2609 최대공약수와 최소공배수
public class q2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		int GCD=0, LCM=0;
		GCD = getGcd(Math.max(n1, n2), Math.min(n1, n2));
		LCM = n1 * n2 / GCD;
		
		System.out.println(GCD);
		System.out.println(LCM);
	}

	private static int getGcd(int n1, int n2) {
		if(n1%n2==0) {
			return n2;
		}
		
		return getGcd(n2, n1%n2);
	}
}
