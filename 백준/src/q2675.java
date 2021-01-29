import java.util.Scanner;

//Q.2675 문자열 반복
public class q2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int R = sc.nextInt();
			String str = sc.next();
			for(int i=0; i<str.length(); i++) {
				for(int r=0; r<R; r++) {
					sb.append("" + str.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
