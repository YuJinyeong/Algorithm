import java.util.Arrays;
import java.util.Scanner;

public class q15655 {

	static int[] arr;
	static int N;
	static int R;
	static int[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N];
		sel = new int[R];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		comb(0,0);
	}

	private static void comb(int idx, int s_idx) {
		if(s_idx == R) {
			for(int i=0; i<s_idx; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		if(idx == N) {
			return;
		}
		sel[s_idx] = arr[idx];
		comb(idx+1,s_idx+1);
		comb(idx+1,s_idx);
		
	}
}
