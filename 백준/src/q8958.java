import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.8958 OX퀴즈
public class q8958 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		String input = "";
		int result = 0, scr = 0;
		for(int tc=0; tc<T; tc++) {
			result = 0;
			scr = 0;
			input = in.readLine();
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == 'O') {
					result += ++scr;
				}
				else {
					scr = 0;
				}
			}
			System.out.println(result);
		}
		
	}
}
