import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.2742 기찍N
public class q2742 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		while(N>=1) {
			sb.append(N--).append("\n");
		}
		System.out.println(sb);
	}
}
