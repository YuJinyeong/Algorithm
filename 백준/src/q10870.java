import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.10870 피보나치 수 5
public class q10870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int[] arr = new int[21];
		arr[1] = 1;
		arr[2] = 1;
		for(int i=3; i<=n; i++)
			arr[i] = arr[i-2] + arr[i-1];
		
		System.out.println(arr[n]);
	}
}
