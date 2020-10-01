import java.util.Arrays;
import java.util.Scanner;

public class q15663 {
	private static int N, M, S;
	private static int[] numbers, input;
	private static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[M];
		isSelected = new boolean[N];
		input = new int[N];

		boolean[] nums = new boolean[10001];
		int idx = 0;
		for (int n = 0; n < N; n++, idx++) {
			int ipt = sc.nextInt();
			if(nums[ipt]) idx--;
			else {
				input[idx] = ipt;
				nums[ipt] = true;
			}
		}
		S = N - idx;
		Arrays.sort(input);
		System.out.println(Arrays.toString(input));
		permutation(0);
	}

	private static void permutation(int cnt) {

		StringBuilder sb = new StringBuilder();

		if (cnt == M) {
			for (int j = 0; j < M; j++) {
				sb.append(numbers[j] + " ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = S; i < N; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = input[i];
			isSelected[i] = true;

			permutation(cnt + 1);

			isSelected[i] = false;
		}
	}

	
}
