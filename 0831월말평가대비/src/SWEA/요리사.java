package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요리사 {
	static int N, ans, sub;
	static int[][] synergy;
	static int[] sel1, sel2;
	static boolean[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			check = new boolean[N];
			sel1 = new int[N/2];
			sel2 = new int[N/2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 987654321;
			comb(0, 0);
			System.out.println("#" + tc + " " + ans);
			
		}
	}
	
	private static void comb(int idx, int idx_s) {
		if(idx_s == N/2) {
			for(int i=0, j=0; i<N; i++) {
				if(!check[i])
					sel2[j++] = i;
			}
//			System.out.println("sel1: " + Arrays.toString(sel1));
//			System.out.println("sel2: " + Arrays.toString(sel2));
			sub = calc();
			ans = Math.min(ans, sub);
			return;
		}
		
		if(idx == N)
			return;
		
		sel1[idx_s] = idx;

		check[idx] = true;
		comb(idx+1, idx_s + 1);
		
		check[idx] = false;
		comb(idx+1, idx_s);

	}
	
	private static int calc() {
		int sum1=0, sum2=0;
		
		// sel1, sel2 계산
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				sum1 += synergy[sel1[i]][sel1[j]];
				sum2 += synergy[sel2[i]][sel2[j]];
			}
		}
		
		return Math.abs(sum1 - sum2);
	}
}
