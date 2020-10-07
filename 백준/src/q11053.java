import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		for(int i=0; i<N; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
			
			if(temp < 0) {
				temp = Math.abs(temp)-1;
				LIS[temp] = arr[i];
				
				if(temp == size) ++size;
			}
		}
		
		System.out.println(size);
		
	}

}
