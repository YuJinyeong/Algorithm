import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.1717 집합의 표현
public class q1717 {
	static int[] root;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		root = new int[n+1];
		for(int i=1; i<=n; i++)
			root[i] = i;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				union(x, y);
			}else {
				x = find(x);
				y = find(y);
				if(x == y) System.out.println("YES");
				else System.out.println("NO");
			}
		}
		
	}
	
	public static int find(int x) {
		if(root[x] == x)
			return x;
		else
			return root[x] = find(root[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x < y)
				root[y] = x;
			else
				root[x] = y;
		}
	}
}
