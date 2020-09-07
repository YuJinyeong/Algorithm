import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Q.4406 모음이 보이지 않는 사람
public class q4406 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb;
		int T = Integer.parseInt(br.readLine());
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuffer();
			char[] input = br.readLine().toCharArray();
			for(int i=0; i<input.length; i++) {
				int j;
				for(j=0; j<vowels.length; j++) {
					if(input[i] == vowels[j]) {
						break;
					}
				}if(j==vowels.length) sb.append(input[i]);
			}
			System.out.println("#" + tc + " " + sb);
			
		}
	}

}
