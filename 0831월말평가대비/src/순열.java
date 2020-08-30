import java.util.Arrays;

public class 순열 {
	static int[] arr = { 1, 3, 5 };
	static int N = arr.length;
	static int[] sel = new int[N]; // arr과 같은 크기
	static boolean[] check = new boolean[N];

	public static void main(String[] args) {
		perm(0);
	}

	private static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				sel[idx] = arr[i];
				perm(idx + 1);
				check[i] = false;
			}
		}
	}

}
