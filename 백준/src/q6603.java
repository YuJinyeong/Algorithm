import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//Q.6603 로또
public class q6603 {
	static int k, S[], Lotto[];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			k = sc.nextInt();
			
			if(k == 0) break;
			
			S = new int[k];
			for(int i=0; i<k; i++)
				S[i] = sc.nextInt();
			
			Lotto = new int[6];
			chooseNumber(0, 0);
			System.out.println();
		}
	}

	private static void chooseNumber(int idx, int idx_sel) {
		if(idx_sel == 6) {
			for(int i=0; i<6; i++) {
				System.out.print(Lotto[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if(idx == k) return;
		
		Lotto[idx_sel] = S[idx];
		chooseNumber(idx+1, idx_sel+1);
		chooseNumber(idx+1, idx_sel);
	}
}
