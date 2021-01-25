import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.StringTokenizer;

//Q.10867 중복 빼고 정렬하기
public class q10867 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		TreeSet<Integer> set = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		Iterator<Integer> iter = set.iterator();
		System.out.print(iter.next());
		while(iter.hasNext()) {
			System.out.print(" " + iter.next());
		}
		
	}
}
