import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.14891 톱니바퀴
public class q14891 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] gears = new String[5];
		for(int i=1; i<=4; i++) {
			gears[i] = in.readLine();
		}
		int K = Integer.parseInt(in.readLine());
		Queue<int[]> qu;
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(in.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			qu = new LinkedList<>();
			qu.add(new int[] {idx, dir});
			
			//왼쪽
			int i = idx, d = dir;
			while(i > 1) {
				if(gears[i].charAt(6) == gears[i-1].charAt(2)) {
					//같으면 회전하지 않음
					break;
				}
				i--;
				d *= -1;
				qu.add(new int[] {i, d});
			}
			
			//오른쪽
			i = idx;
			d = dir;
			while(i < 4) {
				if(gears[i].charAt(2) == gears[i+1].charAt(6)) {
					//같으면 회전하지 않음
					break;
				}
				i++;
				d *= -1;
				qu.add(new int[] {i, d});
			}
			
			//톱니바퀴 회전
			while(!qu.isEmpty()) {
				int[] cur = qu.poll();
//				System.out.println(cur[0] + " 회전" + cur[1]);
				String gear = gears[cur[0]];
				if(cur[1] == 1) { //시계방향 회전
					gear = gear.charAt(gear.length()-1) + gear;
					gears[cur[0]] = gear.substring(0, gear.length()-1);
				}else { //반시계방향 회전
					gear = gear + gear.charAt(0);
					gears[cur[0]] = gear.substring(1);
				}
//				System.out.println(gears[cur[0]]);
			}
		}
		
		int scr = 0;
		int two = 1;
		for(int i=1; i<=4; i++) {
//			System.out.println(gears[i]);
			if(gears[i].charAt(0) == '1')
				scr += two;
			two *= 2;
		}
		System.out.println(scr);
		
		
	}
}
