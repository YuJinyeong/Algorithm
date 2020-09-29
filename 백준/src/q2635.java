import java.util.Scanner;

public class q2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int max = 0;
		int max_idx = -1;
		
		int c, n, sub;
		for(int i=1; i<=N; i++) {
			c = N;
			n = i;
			int k = 2;
			while(c>=n) {
				sub = c-n;
				c = n;
				n = sub;
				k++;
			}
			if(max < k) {
				max = k;
				max_idx = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max + "\n");
		sb.append(N + " " + max_idx + " ");
		c = N;
		n = max_idx;
		while(c>=n) {
			sub = c - n;
			c = n;
			n = sub;
			sb.append(sub + " ");
		}
		System.out.println(sb.toString());
	}

}
