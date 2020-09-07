import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2117 {

	static int N, M, map[][], house, max_size, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			house = 0;
			max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						house++;
				}
			}

			max_size = 1;
			while (max_size <= N) {
				if ((max_size * max_size + (max_size - 1) * (max_size - 1)) >= M * house) {
					break;
				}
				max_size++;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					process(i, j);
				}
			}

			System.out.println("#" + tc + " " + max);
		} // tc end
	}// main end

	private static void process(int r, int c) {
//		System.out.println("process(" + r + ", " + c + ")");
		int safeHouse = 0;
		int op_bud = 0;
		for (int n = 1; n <= max_size; n++) {
			op_bud = n * n + (n - 1) * (n - 1);
			safeHouse = 0;
//			System.out.print(n + " 일 때, ");
			for (int i = r - n + 1, h = 0; i < r + n; i++, h++) {
				if (i < 0 || i >= N)
					continue;
				
				if(i<r) {
					for (int j = c - h; j <= c + h; j++) {
						if (j < 0 || j >= N)
							continue;
						if (map[i][j] == 1) {
//							System.out.println("(" + i + ", " + j + ")");
							safeHouse++;
						}
					}
				}else {
					for (int j = c - h; j <= c + h; j++) {
						if (j < 0 || j >= N)
							continue;
						if (map[i][j] == 1) {
//							System.out.println("(" + i + ", " + j + ")");
							safeHouse++;
						}
					}
					h-=2;
				}
			}
//			System.out.println("집: " + fee / M + ", op_bud: " + op_bud);
			if (safeHouse*M >= op_bud && max < safeHouse) {
				max = safeHouse;
			}
			safeHouse = 0;
		}
	}

}
