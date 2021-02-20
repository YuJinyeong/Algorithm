import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.2386 도비의 영어 공부
public class q2386 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(in.readLine(), " ");
			char c = st.nextToken().charAt(0);
			if(c == '#')	break;
			
			int cnt = 0;
			while(st.hasMoreTokens()) {
				String str = st.nextToken().toUpperCase();
				for(int i=0; i<str.length(); i++) 
					if(c == str.charAt(i) || c == str.charAt(i)+32)	cnt++;
			}
			
			System.out.println(c + " " + cnt);
		}
	}
}
