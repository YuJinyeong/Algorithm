package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 준환이의양팔저울 {
	static int N, cnt;
	static int[] arr, sel;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			check = new boolean[N];
			sel = new int[N];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			cnt = 0;
			perm(0);
//			go(0, 0, 0);
			System.out.println("#" + tc + " " + cnt);
		}
	}

	private static void perm(int idx) {
		if(idx == N) {
//			System.out.println(Arrays.toString(sel));
			go(0, 0, 0);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!check[i]) {
				check[i] = true;
				sel[idx] = arr[i];
				perm(idx+1);
				check[i] = false;
			}
		}
	}

	private static void go(int idx, int left, int right) {
		if (left < right)
			return;

		if (idx == N) {
			// 모든 추가 저울 위에 있음
//			System.out.println(left + ", " + right);
			cnt++;
			return;
		}

		go(idx + 1, left + sel[idx], right);
		go(idx + 1, left, right + sel[idx]);

	}
}
