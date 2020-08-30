package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class 결혼식 {
	
	static boolean[] visited;
	static Node[] graph;
	
	static class Node{
		int val;
		List<Integer> list;
		
		Node(int val){
			this.val = val;
			list = new LinkedList<>();
		}
		void connect(int n){
			list.add(n);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		visited = new boolean[N+1];
		graph = new Node[N+1];
		
		for(int i=0; i<N+1; i++) {
			graph[i] = new Node(i);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].connect(b);
			graph[b].connect(a);
		}
		
		Queue<Node> qu = new LinkedList<>();
		visited[0] = true;
		visited[1] = true;
		qu.add(graph[1]);
		qu.add(graph[0]);
		int cnt = 0;
		while(!qu.isEmpty()) {
			Node n = qu.poll();
			if(n.val == 0) {
				cnt++;
				qu.add(graph[0]);
			}
			if(cnt>1) break;
			List<Integer> list = n.list;
			Iterator<Integer> iter = list.iterator();
			while(iter.hasNext()) {
				int nxt = iter.next();
				if(!visited[nxt]) {
					visited[nxt] = true;
					qu.add(graph[nxt]);
					System.out.println(nxt);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}
