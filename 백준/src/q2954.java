import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.2954 창영이의 일기장
public class q2954 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] diary = in.readLine().toCharArray();
		
		for(int i=0; i<diary.length; i++) {
			char c = diary[i];
			sb.append(c);
			if("aeiou".contains(""+c)) i+=2;
		}
		
		System.out.println(sb.toString());
	}
}
