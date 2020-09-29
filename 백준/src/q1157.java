import java.util.Scanner;

public class q1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();
		
		int[] cnt = new int[26];
		
		int max = 0;
		char ans = '?';
		for(int i=0; i<str.length(); i++) {
			int n = str.charAt(i)-'A';
			cnt[n]++;
			if(cnt[n]>max) {
				ans = (char)('A' + n);
				max = cnt[n];
			}
			else if(cnt[n]==max)
				ans = '?';
		}
		
		System.out.println(ans);
	}
}
