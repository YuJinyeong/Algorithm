package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Q.1986 지그재그 숫자
public class q1986 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int Answer = 0;
			Answer = N / 2 * (-1);
			if (N % 2 == 1)
				Answer += N;
			System.out.println("#" + tc + " " + Answer);
		}
	}

}
