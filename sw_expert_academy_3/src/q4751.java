import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Q.4751 다솔이의 다이아몬드 장식
public class q4751 {
	static int length;
	static StringBuilder sb;
	
	public static void first() {
		for(int i=0; i<length;i++) {
			sb.append("..#.");
		}
		sb.append(".");
	}
	
	public static void second() {
		for(int i=0; i<length; i++) {
			sb.append(".#.#");
		}
		sb.append(".");
	}
	
	public static void third(String s) {
		for(int i=0; i<length; i++) {
			sb.append("#." + s.charAt(i) + ".");
		}
		sb.append("#");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		String s;
		for(int tc=1; tc<=TC; tc++) {
			sb = new StringBuilder();
			s = br.readLine().trim();
			length = s.length();
			sb = new StringBuilder();
			first();
			sb.append("\n");
			second();
			sb.append("\n");
			third(s);
			sb.append("\n");
			second();
			sb.append("\n");
			first();
			System.out.println(sb);
		}
	}

}