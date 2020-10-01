import java.util.Scanner;

public class q15652 {
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
			input[i] = i + 1;
		}

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

		int min = 0;
		if(cnt > 0) min = numbers[cnt-1]-1;
		for (int i = min; i < N; i++) {
			numbers[cnt] = input[i];
			permutation(cnt + 1);
		}
	}
}
