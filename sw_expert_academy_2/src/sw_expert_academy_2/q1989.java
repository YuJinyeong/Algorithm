package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Q.1989 초심자의 회문검사
public class q1989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int Answer = 1;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					Answer = 0;
					break;
				}
			}
			System.out.println("#" + tc + " " + Answer);
		}
	}
}
