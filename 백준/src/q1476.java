import java.util.Scanner;

public class q1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int n = 1;
		while(true) {
			if((n-E)%15==0 && (n-S)%28==0 && (n-M)%19==0)
				break;
			n++;
		}
		System.out.println(n);
	}
}
