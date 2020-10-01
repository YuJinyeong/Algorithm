import java.util.Scanner;

public class q2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>i; j--)
				System.out.print(" ");
			for(int j=0; j<2*i+1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
