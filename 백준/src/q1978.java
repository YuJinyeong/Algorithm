import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.1978 소수 찾기
public class q1978 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		boolean[] check = new boolean[1001];
		check[1] = true;
		for(int i=2; i<1001; i++) {
			boolean isDecimal = true;
			for(int j=2; j<i; j++) {
				if(i%j == 0) {
					isDecimal = false;
					break;
				}
			}
			if(!isDecimal) 	check[i] = true;
			int num = i*2;
			while(num<1001) {
				check[num] = true;
				num += i;
			}
		}
		int cnt = 0;
		for(int n=0; n<N; n++) {
			int num = Integer.parseInt(st.nextToken());
			if(!check[num]) cnt++;
		}
		System.out.println(cnt);
		
	}
}
