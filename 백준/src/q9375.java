import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

//Q.9375 패션왕 신해빈
public class q9375 {
	static class Clothes{
		String type;
		int num;
		Clothes(String type, int num){
			this.type = type;
			this.num = num;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		Iterator<Clothes> iter;
		String name="", type="";
		HashSet<Clothes> set = null;
		Clothes c = null;
		int n=0, answer=0;
		for(int tc=0; tc<T; tc++) {
			n = Integer.parseInt(in.readLine());
			set = new HashSet<>();
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				name = st.nextToken();
				type = st.nextToken();
				
				iter = set.iterator();
				boolean flag = false;
				while(iter.hasNext()) {
					c = iter.next();
					if(c.type.equals(type)) {
						c.num++;
						flag = true;
					}
				}
				if(!flag)	set.add(new Clothes(type, 1));
			}
			
			answer = 1;
			iter = set.iterator();
			while(iter.hasNext()) {
				c = iter.next();
//				System.out.println(c.type + " " + c.num);
				answer *= (c.num+1);
			}
			
			System.out.println(answer-1);
		}
		
	}
}
