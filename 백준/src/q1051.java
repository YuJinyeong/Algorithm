import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int len = max + 1;
				while(true) {
//					System.out.println("(" + i + ", " + j + ") => " + len);
					if(i + len >= N || j + len >= M)
						break;
					if (arr[i][j] == arr[i + len][j] && arr[i][j] == arr[i][j + len] && arr[i][j] == arr[i + len][j + len]) {
						max = len;
//						System.out.println(max);
					}
					len++;
				}
			}
		}
		
		
		max += 1;
		System.out.println(max*max);

	}

}
