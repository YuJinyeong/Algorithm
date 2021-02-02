import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.17143 낚시왕
public class q17143 {
	static class Shark{
		int r, c, s, d, z;
		Shark(int r, int c, int s, int d, int z){
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[R+1][C+1];

		Map<Integer, Shark> sharks = new HashMap<>();
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[r][c] = z;
			sharks.put(z, new Shark(r, c, s, d, z));
		}
		

		int[] dr = {0, -1, 1, 0, 0};
		int[] dc = {0, 0, 0, 1, -1};
		
		int total = 0;
		for(int fisher = 1; fisher <= C; fisher++) {//낚시왕이 오른쪽으로 한 칸 이동한다
			
			//낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다
			for(int i=1; i<=R; i++) {
				if(map[i][fisher] != 0) {
					//상어를 잡으면 격자판에서 잡은 상어가 사라진다
					total += map[i][fisher];
					sharks.remove(map[i][fisher]);
					map[i][fisher] = 0;
					break;
				}
			}
			
			//상어가 이동한다
			Queue<Integer> losers = new LinkedList<>();
			int[][] after = new int[R+1][C+1];
			for(int key : sharks.keySet()) {
				Shark s = sharks.get(key);
				map[s.r][s.c] = 0;
				
				int dis = s.d<3? s.s%(R*2-2):s.s%(C*2-2);
				
				for(int i=0; i<dis; i++) {
					//격자판의 경계를 넘는 경우에는
					if(s.d == 1 && s.r == 1)
						s.d = 2;
					else if(s.d == 2 && s.r == R)
						s.d = 1;
					else if(s.d == 3 && s.c == C)
						s.d = 4;
					else if(s.d == 4 && s.c == 1)
						s.d = 3;
					
					s.r += dr[s.d];
					s.c += dc[s.d];
					
				}
				
				if(after[s.r][s.c] == 0) {
					after[s.r][s.c] = s.z;
				}else if(s.z > after[s.r][s.c]) {
					losers.add(after[s.r][s.c]);
					after[s.r][s.c] = s.z;
				}else {
					losers.add(s.z);
				}
			}
			
			while(!losers.isEmpty()) {
				sharks.remove(losers.poll());
			}
			
			for(int key : sharks.keySet()) {
				Shark s = sharks.get(key);
				map[s.r][s.c] = after[s.r][s.c];
			}
			
		}
		
		System.out.println(total);
		
	}
}
