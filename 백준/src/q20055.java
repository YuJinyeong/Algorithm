import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.20055 컨베이어 벨트 위의 로봇
public class q20055 {
	static int N, K, A[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int zeros = 0;
		A = new int[2 * N + 1];
		boolean[] Robots = new boolean[N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= 2 * N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (A[i] == 0)
				zeros++;
		}

		int step = 1;
		while (true) {

			// 벨트가 한 칸 회전한다(로봇도 같이 회전한다)
			int t = A[2 * N];
			for (int i = 2 * N; i > 1; i--) {
				A[i] = A[i - 1];
			}
			A[1] = t;

			// 로봇이 한 칸 회전한다
			boolean t2 = Robots[N];
			for (int i = N; i > 1; i--) {
				Robots[i] = Robots[i - 1];
			}
			Robots[1] = t2;
			if(Robots[N]) Robots[N] = false;

			// 먼저 올라간 로봇부터 한칸 이동할 수 있으면 이동
			for (int n = N-1; n > 0; n--) {
				if (Robots[n]) {
					int nxt = n + 1;
					if (!Robots[nxt] && A[nxt] > 0) {
						Robots[n] = false;
						Robots[nxt] = true;
						A[nxt]--;
	
						if (A[nxt] == 0)	zeros++;
					}
				}
			}
			if(Robots[N]) Robots[N] = false;

			// 올라가는 위치에 로봇이 없으면 로봇을 하나 올린다
			if (!Robots[1] && A[1] > 0) {
				Robots[1] = true;
				A[1]--;
				if (A[1] == 0)	zeros++;
			}

			// 내구도가 0인 칸이 K개 이상이면 멈춤
			if (zeros >= K)
				break;

			// 아니면 계속
			step++;
		}
		System.out.println(step);
	}
}
