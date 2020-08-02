package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Q.1983 조교의 성적 매기기
public class q1983 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] score = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()) - 1;
			double K_score = 0.0;
			double [] scores = new double[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				while(st.hasMoreTokens()) {
					double mid = 0.35 * Integer.parseInt(st.nextToken());
					double fin = 0.45 * Integer.parseInt(st.nextToken());
					double hw = 0.2 * Integer.parseInt(st.nextToken());
					scores[i] = mid + fin + hw;
				}
				if(i==K)	K_score = scores[i];
			}
			Arrays.sort(scores);
			int idx = 0;
			while(scores[idx] != K_score) {
				idx++;
			}
			System.out.println("#" + tc + " " + score[idx/(N/10)]);
		}
	}

}
