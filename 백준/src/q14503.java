import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14503 {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int dd[] = {3, 0, 1, 2};
	static int nr, nc, nd, map[][], cleaned, turn;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		

		map = new int[N][M];
		st = new StringTokenizer(in.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		cleaned = 0;
		turn = 0;
		
		//현재 위치를 청소한다.
		map[r][c] = 2;
		cleaned++;
		
		while(true) {
			//4방향 모두 청소가 되어 있다면
			if(turn == 4) {
				//현재 방향 그대로 한 칸 후진
				nr = r - dr[d];
				nc = c - dc[d];
				
				if(map[nr][nc] == 1) {//후진도 할 수 없으면 종료
					break;
				}
				
				//후진하고 다시 탐색 시작..
				r = nr;
				c = nc;
				turn = 0;
			}
			
			//왼쪽 방향 탐색
			nd = dd[d]; //현재 방향의 왼쪽
			nr = r + dr[nd];
			nc = c + dc[nd];
			
			//왼쪽 방향에 청소하지 않은 공간이 존재한다면
			if(map[nr][nc] == 0) {
				//회전한 다음 전진
				d = nd;
				r = nr;
				c = nc;
				turn = 0;

				//청소
//				System.out.println(r + ", " + c + ": " + d);
				map[r][c] = 2;
				cleaned ++;
			}else {//왼쪽 방향에 청소하지 않은 공간이 없다면
				d = nd; //회전한 다음 다시 탐색..
				turn++;
				continue;
			}
		}
		
		System.out.println(cleaned);
	}
}
