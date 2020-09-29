import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2304 {
	static int[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		map = new int[1001];
		int max_idx = 0;
		int min_idx = Integer.MAX_VALUE;
		
		int h = 0, res = 0, h_idx = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			max_idx = Math.max(max_idx, n1);
			min_idx = Math.min(min_idx, n1);
			if(h < n2) {
				h = n2;
				h_idx = n1;
			}
			map[n1] = n2;
		}
		
		System.out.println((h + right_sum(max_idx, h_idx) + left_sum(min_idx, h_idx)));
	}

	private static int left_sum(int min_idx, int h_idx) {
		int sum = 0;
		int max = 0;
		for(int i=min_idx; i<h_idx; i++) {
			if(map[i] > max) {
				max = map[i];
			}
			sum += max;
		}
		return sum;
	}

	private static int right_sum(int max_idx, int h_idx) {
		int sum = 0;
		int max = 0;
		for(int i=max_idx; i>h_idx; i--) {
			if(map[i] > max) {
				max = map[i];
			}
			sum += max;
		}
		return sum;
	}
}
