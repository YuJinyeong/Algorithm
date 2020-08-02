package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Q.1946 간단한 압축 풀기
public class q1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb;
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc);
			sb = new StringBuffer();
			int N = Integer.parseInt(br.readLine());
			int length = 0;
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				String alpha = st.nextToken();
				int repetition = Integer.parseInt(st.nextToken());
				for (int i = 0; i < repetition; i++) {
					sb.append(alpha);
					length++;
					if(length == 10) {
						sb.append("\n");
						length = 0;
					}
				}
			}
			System.out.println(sb);
		}
	}

}
