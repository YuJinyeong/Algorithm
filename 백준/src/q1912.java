import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.1259 팰린드롬수
public class q1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String N = "";
		while(true) {
			N = in.readLine();
			if(N.equals("0")) break;
			StringBuilder sb = new StringBuilder(N);
			if(sb.toString().equals(sb.reverse().toString()))
				System.out.println("yes");
			else
				System.out.println("no");
			
		}
	}
}
