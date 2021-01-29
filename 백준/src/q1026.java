import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Q.1026 보물
public class q1026 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) 
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			B[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			answer += A[i] * B[N-1-i];
		}
		
		System.out.println(answer);
	}
}
