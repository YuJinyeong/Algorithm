import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.14696 딱지놀이
public class q14696 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final int STAR=4, CIRCLE=3, SQUARE=2, TRIANGLE=1;
		int N = Integer.parseInt(in.readLine());
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int[] A = new int[5];
			for(int i=0; i<a; i++) 
				A[Integer.parseInt(st.nextToken())]++;
			
			st = new StringTokenizer(in.readLine(), " ");
			int b = Integer.parseInt(st.nextToken());
			int[] B = new int[5];
			for(int i=0; i<b; i++) 
				B[Integer.parseInt(st.nextToken())]++;
			
			if(A[STAR] > B[STAR]) 
				System.out.println('A');
			else if(A[STAR] < B[STAR])
				System.out.println('B');
			else if(A[CIRCLE] > B[CIRCLE])
				System.out.println('A');
			else if(A[CIRCLE] < B[CIRCLE])
				System.out.println('B');
			else if(A[SQUARE] > B[SQUARE])
				System.out.println('A');
			else if(A[SQUARE] < B[SQUARE])
				System.out.println('B');
			else if(A[TRIANGLE] > B[TRIANGLE])
				System.out.println('A');
			else if(A[TRIANGLE] < B[TRIANGLE])
				System.out.println('B');
			else
				System.out.println('D');
			
		}
	}
}
