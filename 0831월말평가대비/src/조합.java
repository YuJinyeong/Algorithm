import java.util.Arrays;

public class 조합 {
	static int[] arr = { 1, 3, 5 };
	static int N = arr.length, R = arr.length - 1;
	static int[] sel = new int[R]; // arr과 같은 크기
	static int idx, s_idx;

	public static void main(String[] args) {
		comb(0, 0);
	}

	private static void comb(int idx, int idx_s) {
		if (idx_s == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		if (idx == N) {
			return;
		}

		sel[idx_s] = arr[idx];
		comb(idx + 1, idx_s + 1);
		comb(idx + 1, idx_s);
	}
}
