package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Q.1979 쉬운 거스름돈
public class q1970 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] unit = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < unit.length; i++) {
				if (N/unit[i] > 0) {
					sb.append(N / unit[i] + " ");
					N %= unit[i];
				}else {
					sb.append(0 + " ");
				}
			}

			System.out.print("#" + tc + "\n" + sb);
		}

	}

}
