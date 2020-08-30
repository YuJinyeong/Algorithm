package sw_expert_academy_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Q.2007 패턴 마디의 길이
public class q2007 {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            char start = str.charAt(0);
            String pattern = "";
            boolean pass;
            for (int i = 1; i < 10; i++) {
                if(start == str.charAt(i)) {
                    pattern = str.substring(0, i);
                    pass = true;
                    for(int j=i; j<10; j+=i) {
                    	String nxt = str.substring(j, j+i);
                    	if(!pattern.equals(nxt)) {
                    		pass = false;
                    		break;
                    	}
                    }
                    if(pass) {
                    	System.out.println("#" + tc + " " + pattern.length());
                        break;
                    }
                }
            }
        }
    }
}
