import java.util.Scanner;

//Q.1924 2007년
public class q1924 {
	public static void main(String[] args) {
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int sum = 0;
		for(int i=1; i<x; i++) {
			sum += days[i];
		}
		sum += y;
		System.out.println(day[sum%7]);
	}
}
