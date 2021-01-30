import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.1043 거짓말
public class q1043 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] known = new int[N + 1];
		boolean[] check = new boolean[N + 1];
		boolean[][] list = new boolean[N + 1][M];
		boolean[] truthParty = new boolean[M];
		int answer = M;

		int idx = 0;
		st = new StringTokenizer(in.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		while (st.hasMoreTokens()) {
			known[idx] = Integer.parseInt(st.nextToken());
			check[known[idx]] = true;
			idx++;
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(in.readLine(), " ");
			st.nextToken();
			while (st.hasMoreTokens())
				list[Integer.parseInt(st.nextToken())][m] = true;
		}

		for (int i = 0; i < idx; i++) {
			int person = known[i];
//			System.out.println("진실을 아는 사람: " + person);
			// 진실을 아는 사람이 간 파티 확인
			for (int m = 0; m < M; m++) {
				if (list[person][m] && !truthParty[m]) {// 진실을 아는 사람이 간 진실을 말하지 않은 파티

					// 진실을 말함
					truthParty[m] = true;
					answer--;
//					System.out.println("진실을 말하는 파티: " + m);

					// 파티에 있는 사람들은 진실을 알게됨
					for (int p = 1; p <= N; p++) {
						// 파티에 참석했고 진실을 모르는 경우 명단에 추가
						if (list[p][m] && !check[p]) {
							check[p] = true;
							known[idx++] = p;
//							System.out.println("새로 진실을 알게된 사람: " + p);
						}
					}
				}
			}
		}

		System.out.println(answer);
	}
}
