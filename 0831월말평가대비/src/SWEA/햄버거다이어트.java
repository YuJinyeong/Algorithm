package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거다이어트 {
	static int N, L, ans;
	static int[][] info;
	static int[] sel;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); //재료의 수
			L = Integer.parseInt(st.nextToken()); //제한 칼로리
			info = new int[N][2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				info[i][0] = Integer.parseInt(st.nextToken()); //점수
				info[i][1] = Integer.parseInt(st.nextToken()); //칼로리
			}
			
			ans = 0;
			comb(0, 0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	private static void comb(int idx, int sum_scr, int sum_cal) {
		if(sum_cal > L)
			return;
		
		if(idx == N) {
			ans = Math.max(ans, sum_scr);
			return;
		}
		
		comb(idx+1, sum_scr + info[idx][0], sum_cal + info[idx][1]);
		comb(idx+1, sum_scr, sum_cal);
	}

}
