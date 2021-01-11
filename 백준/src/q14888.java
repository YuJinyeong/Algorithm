import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.14888 연산자 끼워넣기
public class q14888 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] oper = new int[4];
		
		st = new StringTokenizer(in.readLine(), " ");
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine(), " ");
		for(int n=0; n<4; n++) {
			oper[n] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {arr[0], oper[0], oper[1], oper[2], oper[3], 0});
		int idx = 1;
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			idx = cur[5];
			
			if(idx == N-1) {
				min = Math.min(cur[0], min);
				max = Math.max(cur[0], max);
			}
			
			if(cur[1] != 0) 
				qu.add(new int[] {cur[0]+arr[idx+1], cur[1]-1, cur[2], cur[3], cur[4], idx+1});
				
			if(cur[2] != 0) 
				qu.add(new int[] {cur[0]-arr[idx+1], cur[1], cur[2]-1, cur[3], cur[4], idx+1});
				
			if(cur[3] != 0) 
				qu.add(new int[] {cur[0]*arr[idx+1], cur[1], cur[2], cur[3]-1, cur[4], idx+1});
				
			if(cur[4] != 0) 
				qu.add(new int[] {cur[0]/arr[idx+1], cur[1], cur[2], cur[3], cur[4]-1, idx+1});
				
		}
		System.out.println(max + "\n" + min);
		
	}
}
