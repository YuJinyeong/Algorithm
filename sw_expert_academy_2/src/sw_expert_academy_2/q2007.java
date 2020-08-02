package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Q.2007 패턴 마디의 길이
public class q2007 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			char start = str.charAt(0);
			String pattern = "";
			for (int i = 1; i <= 10; i++) {
				if(start == str.charAt(i)) {
					pattern = str.substring(0, i);
					String nxt = str.substring(i, i*2);
					String nxt2 = str.substring(i*2, i*3);
					if(pattern.equals(nxt) && pattern.equals(nxt2)) {
						System.out.println("#" + tc + " " + pattern.length());
						break;
					}
				}
			}
		}
	}

}
