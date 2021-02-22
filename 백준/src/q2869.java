import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.2869 달팽이는 올라가고 싶다
public class q2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int UP = Integer.parseInt(st.nextToken());
		int DOWN = Integer.parseInt(st.nextToken());
		int GOAL = Integer.parseInt(st.nextToken());

		int day = (int) Math.ceil(((double)GOAL - UP)/(UP-DOWN));
		System.out.println(day+1);
		
	}
}
