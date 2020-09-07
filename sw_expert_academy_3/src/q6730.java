import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Q. 6730 장애물 경주 난이도
public class q6730 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int max_up, max_down;
		for (int tc = 1; tc <= T; tc++) {
			max_up = 0;
			max_down = 0;
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int b1 = Integer.parseInt(st.nextToken());
			int b2;
			while (st.hasMoreTokens()) {
				b2 = Integer.parseInt(st.nextToken());
				if (b1 > b2)
					max_down = Math.max(b1 - b2, max_down);
				else
					max_up = Math.max(b2 - b1, max_up);
				b1 = b2;
			}
			System.out.println("#" + tc + " " + max_up + " " + max_down);
		}
	}

}
