import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.9205 맥주 마시면서 걸어가기
public class q9205 {
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		int n = 0;
		Node[] nodes;
		boolean[][] visited;
		Node fin=null;
		Queue<Integer> qu;
		String answer;
		
		for(int tc=0; tc<T; tc++) {
			answer = "sad";
			n = Integer.parseInt(in.readLine());
			nodes = new Node[n+1];
			visited = new boolean[n+1][n+1];
			st = new StringTokenizer(in.readLine(), " ");
			nodes[0] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(in.readLine(), " ");
			fin = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			if(Math.abs(nodes[0].x - fin.x) + Math.abs(nodes[0].y - fin.y) <= 20*50) {
				answer = "happy";
			}else {
				qu = new LinkedList<>();
				qu.add(0);
				while(!qu.isEmpty()) {
					int idx = qu.poll();
					Node cur = nodes[idx];
					
					if(Math.abs(cur.x - fin.x) + Math.abs(cur.y - fin.y) <= 20*50) {
						answer = "happy";						
						break;
					}
					
					for(int i=1; i<=n; i++) {	
						if(!visited[idx][i] && Math.abs(cur.x-nodes[i].x)+Math.abs(cur.y-nodes[i].y) <= 20*50) {
							visited[idx][i] = true;
							visited[i][idx] = true;
							qu.add(i);
						}
					}
				}
			}
			
			System.out.println(answer);
		}
	}
}
