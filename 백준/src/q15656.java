import java.util.Arrays;
import java.util.Scanner;

public class q15656 {
	private static int N, M;
	private static int[] numbers, input;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[M];
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		permutation(0);
		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if (cnt == M) {
			for (int j = 0; j < M; j++) {
				sb.append(numbers[j] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			numbers[cnt] = input[i];
			permutation(cnt + 1);
		}
	}

	
}
