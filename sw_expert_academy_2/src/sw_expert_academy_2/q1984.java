package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Q.1984 중간 평균값 구하기
public class q1984 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sum = Integer.parseInt(st.nextToken());
			int max = sum;
			int min = sum;
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				sum += n;
				if(n>max) 
					max = n;
				if(n<min)
					min = n;
			}
			sum -= (max + min);
			System.out.println("#" + tc + " " + Math.round(sum/8.0));
		}
	}

}
