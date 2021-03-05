import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Set;

//Q.12886 돌 그룹
public class q12886 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		
		Queue<int[]> qu = new LinkedList<int[]>();
		Set<String> set = new HashSet<>();
		qu.add(new int[] {A, B, C});
		set.add(Arrays.toString(qu.peek()));
		int answer = 0;
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			if(cur[0] == cur[1] && cur[1] == cur[2]) {
				answer = 1;
				break;
			}
			
			Arrays.sort(cur);
//			System.out.println(Arrays.toString(cur));
			
			int[] nxt = new int[] {cur[0]*2, cur[1]-cur[0], cur[2]};
			Arrays.sort(nxt);
			if(!set.contains(Arrays.toString(nxt))) {
				set.add(Arrays.toString(nxt));
				qu.add(nxt);
			}
			
			nxt = new int[] {cur[0]*2, cur[1], cur[2]-cur[0]};
			Arrays.sort(nxt);
			if(!set.contains(Arrays.toString(nxt))) {
				set.add(Arrays.toString(nxt));
				qu.add(nxt);
			}
			
			nxt = new int[] {cur[0], cur[1]*2, cur[2]-cur[1]};
			Arrays.sort(nxt);
			if(!set.contains(Arrays.toString(nxt))) {
				set.add(Arrays.toString(nxt));
				qu.add(nxt);
			}
		}
		System.out.println(answer);
	}
}
