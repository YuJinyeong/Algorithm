import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2491 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int max = 1;

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int up = 1;
		for (int i = 0; i < N - 1; i++) {
			int cur = arr[i];
			if (cur <= arr[i + 1])
				up++;
			else if (cur > arr[i + 1]) {
//				System.out.println("<up> "+ i + " : " + up);
				max = Math.max(max, up);
				up = 1;
			}
		}
		max = Math.max(max, up);
		
		int down = 1;
		for (int i = 0; i < N - 1; i++) {
			int cur = arr[i];
			if (cur < arr[i + 1]) {
//				System.out.println("<down> "+ cur + " : " + down);
				max = Math.max(max, down);
				down = 1;
			}
			else if (cur >= arr[i + 1])
				down++;
		}
		max = Math.max(max, down);

		System.out.println(max);
	}
}
