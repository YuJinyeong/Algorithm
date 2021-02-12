import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Q.1759 암호 만들기
public class q1759 {
	static int L, C;
	static char arr[], sel[];
	static boolean check[];
	static String cols = "aeiou";
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		sel = new char[L];
		check = new boolean[C];
		st = new StringTokenizer(in.readLine(), " ");
		for(int c=0; c<C; c++) {
			arr[c] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		perm(0, 0);
	}

	private static void perm(int idx, int idx_sel) {
		if(idx_sel == L) {
			int con = 0, col = 0;
			for(int i=0; i<L; i++) {
				if(cols.contains("" + sel[i]))
					col++;
				else
					con++;
			}
			if(col<1 || con<2) return;
			for(int i=0; i<L; i++)
				System.out.print(sel[i]);
			System.out.println();
			return;
		}
		
		if(idx == C) return;
		
//		check[idx] = true;
		sel[idx_sel] = arr[idx];
		perm(idx+1, idx_sel+1);
//		check[idx] = false;
		perm(idx+1, idx_sel);
	}
}
