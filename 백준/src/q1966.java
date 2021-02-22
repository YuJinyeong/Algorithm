import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

//Q.1966 프린터큐
public class q1966 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<int[]> printer = new LinkedList<>();
			
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<N; i++)
				printer.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			
			int cnt = 0;
			while(!printer.isEmpty()) {
				int[] cur = printer.poll();
				boolean print = true;
				for(int[] nxt : printer) {
					if(cur[1] < nxt[1]) {
						print = false;
						break;
					}
				}
				if(print) {
					cnt++;
					if(cur[0] == M)
						break;
				}
				else printer.offer(cur);
			}
			System.out.println(cnt);
			
		
		}
		
	}
}
