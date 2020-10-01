import java.util.Scanner;

public class q10995 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			if(i%2==1) System.out.print(" ");
			for(int j=0; j<N; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
