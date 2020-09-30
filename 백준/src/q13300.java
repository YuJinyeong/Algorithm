import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] nums = new int[7][2];
		
		int S=0, Y=0; 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			S = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			nums[Y][S]++;
		}
		
		int ans = 0;
		for(int i=1; i<7; i++) {
			ans += nums[i][0]%K==0?nums[i][0]/K:nums[i][0]/K+1;
			ans += nums[i][1]%K==0?nums[i][1]/K:nums[i][1]/K+1;
		}
		System.out.println(ans);
	}
}
