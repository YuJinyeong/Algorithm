import java.util.Scanner;

//Q.2577 숫자의 개수
public class q2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		String answer = Integer.toString(A * B * C);
		int[] check = new int[10];
		
		for(int i=0; i<answer.length(); i++) {
			check[answer.charAt(i)-'0']++;
		}
		
		
		for(int i=0; i<10; i++) {
			System.out.println(check[i]);
		}
	}
}
