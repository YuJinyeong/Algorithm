package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1204 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int score[];
		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			int mf = 0;
			int mf_value = 0;
			score = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				score[n] += 1;
				if(mf <= score[n]) {
					mf = score[n];
					mf_value = n;
				}
			}
			System.out.println("#" + tc + " " + mf_value);
		}
	}

}
