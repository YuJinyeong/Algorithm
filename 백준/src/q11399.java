import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Q.11399 ATM
public class q11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int wait = 0, sum = arr[0];
		for(int i=1; i<N; i++) {
			arr[i] += arr[i-1];
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
