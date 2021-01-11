import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.5014 스타트링크
public class q5014 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int answer = -1;
		boolean[] check = new boolean[F+1];
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] { S, 0, 0 });
		check[S] = true;
		while (!qu.isEmpty()) {
			int[] cur = qu.poll();
//			System.out.println(cur[1] + " , " + cur[2] + " : " + cur[0]);
			
			if(cur[0] == G) {
				qu.clear();
				answer = cur[1] + cur[2];
				break;
			}
			
			if (cur[0] > F || cur[0] < 1)
				break;
			
			if(cur[0] + U <= F && !check[cur[0] + U]) {
				check[cur[0] + U] = true;
				qu.add(new int[] { cur[0] + U, cur[1] + 1, cur[2] });
			}
			if(cur[0] - D > 0 && !check[cur[0] - D]) {
				check[cur[0] - D] = true;
				qu.add(new int[] { cur[0] - D, cur[1], cur[2] + 1 });
				}

		}
		
		if(answer == -1) 
			System.out.println("use the stairs");
		else
			System.out.println(answer);
	}
}
