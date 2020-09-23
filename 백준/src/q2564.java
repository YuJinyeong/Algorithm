import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N+1][];
		int c, d;
		for(int i=0; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			if(c==1)	map[i] = new int[] {0, d, 1};
			if(c==2)	map[i] = new int[] {H, d, 2};
			if(c==3)	map[i] = new int[] {d, 0, 3};
			if(c==4)	map[i] = new int[] {d, W, 4};
			System.out.println(Arrays.toString(map[i]));
		}
		
		int dist = 0;
		int border_len = (H+W)*2;
		int rev = map[N][2]%2==0?map[N][2]-1:map[N][2]+1;
		for(int i=0; i<N; i++) {
			if(map[i][2]==rev) {
				if(map[i][2]==1 || map[i][2]==2) {
					int tmp = H + map[i][1] + map[N][1];
					dist += Math.min(tmp, border_len-tmp);
				}else {
					int tmp = W + map[i][0] + map[N][0];
					dist += Math.min(tmp, border_len-tmp);
				}
			}
			else
				dist += Math.abs(map[N][0] - map[i][0]) + Math.abs(map[N][1] - map[i][1]);
		}
		
		System.out.println(dist);
	}
}
