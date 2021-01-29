import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.8911 거북이
public class q8911 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		String input = "";
		int d, cR, cC, minR, maxR, minC, maxC;
		for(int tc=0; tc<T; tc++) {
			input = in.readLine();
			d = cR = cC = minR = minC = maxR = maxC = 0;
			
			for(int i=0; i<input.length(); i++) {
				char c = input.charAt(i);
				if(c == 'F') {
					cR += dr[d];
					cC += dc[d];
					minR = Math.min(cR, minR);
					minC = Math.min(cC, minC);
					maxR = Math.max(cR, maxR);
					maxC = Math.max(cC, maxC);
				}else if(c == 'B') {
					cR -= dr[d];
					cC -= dc[d];
					minR = Math.min(cR, minR);
					minC = Math.min(cC, minC);
					maxR = Math.max(cR, maxR);
					maxC = Math.max(cC, maxC);
				}else if(c == 'L') {
					d = (d+3)%4;
				}else {
					d = (d+1)%4;
				}
			}
			
			System.out.println(Math.abs((maxR-minR))*Math.abs((maxC-minC)));
		}
		
	}
}
