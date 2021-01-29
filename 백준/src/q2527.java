import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.2527 직사각형
public class q2527 {
	static class Square{
		int x, y, p, q;
		Square(int x, int y, int p, int q){
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=0; t<4; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			Square s1 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Square s2 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			//겹치지 않는 경우
			if(s1.p < s2.x || s1.q < s2.y || s2.p < s1.x || s2.q < s1.y)
				System.out.println("d");
			
			//점으로 만나는 경우
			else if((s1.p == s2.x && s1.q == s2.y) || (s1.x == s2.p && s1.y == s2.q) 
					|| (s2.p == s1.x && s1.q == s2.y) || (s2.x == s1.p && s1.y == s2.q))
				System.out.println("c");
			
			//선분으로 만나는 경우
			else if(s1.y == s2.q || s2.y == s1.q || s2.x == s1.p || s1.x == s2.p)
				System.out.println("b");
			
			else System.out.println("a");
			
		}
	}
}
