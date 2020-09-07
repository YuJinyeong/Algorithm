import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Q.3431 준환이의 운동관리
public class q3431 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int L = 0, U = 0, X = 0, Answer;
		for (int tc = 1; tc <= T; tc++) {
			Answer = 0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				L = Integer.parseInt(st.nextToken());
				U = Integer.parseInt(st.nextToken());
				X = Integer.parseInt(st.nextToken());
			}
			if(X > U) {
				Answer = -1;
			}else if(X < L) {
				Answer = L - X;
			}
			System.out.println("#" + tc + " " + Answer);
		}
	}

}
