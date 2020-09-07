import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Q.9997 미니멀리즘 시계
public class q9997 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int h = 0, m = 0;
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			h = N/30;
			m = (N%30)*2;
			if(h==12)	h = 0;
			System.out.println("#" + tc + " " + h + " " + m);
		}
	}

}
