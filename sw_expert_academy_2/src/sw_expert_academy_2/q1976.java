package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Q.1926 시각덧셈
public class q1976 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] inputs = br.readLine().split(" ");
			int h1 = Integer.parseInt(inputs[0]);
			int m1 = Integer.parseInt(inputs[1]);
			int h2 = Integer.parseInt(inputs[2]);
			int m2 = Integer.parseInt(inputs[3]);
			
			int ans_h = h1 + h2;
			int ans_m = m1 + m2;
			
			if(ans_m > 60) {
				ans_m = m1 + m2 - 60;
				ans_h += 1;
			}
			if(ans_h > 12) {
				ans_h -= 12;
			}
			
			System.out.println("#" + tc + " " + ans_h + " " + ans_m);
		}
	}

}
