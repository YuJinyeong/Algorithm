import java.util.Scanner;

public class q1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] arr = new int[41][41];
		
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		
		for(int i=2; i<=40; i++) {
			arr[i][0] = arr[i-1][0] + arr[i-2][0];
			arr[i][1] = arr[i-1][1] + arr[i-2][1];
		}
		
		
		
		
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			System.out.println(arr[N][0] + " " + arr[N][1]);
		}
	}
}
