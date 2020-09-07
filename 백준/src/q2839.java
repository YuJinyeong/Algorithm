import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = -1, cnt = 0;
		
		while(true) {
			if(N%5 == 0) {
				ans = cnt + N/5;
				break;
			}
			if(N<5 && N%3!=0) {
				ans = -1;
				break;
			}
			N -= 3;
			cnt++;
		}
		
		System.out.println(ans);
	}

}
