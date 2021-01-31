import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//Q.16954 움직이는 미로 탈출
public class q16954 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[8][];
		for (int i = 0; i < 8; i++) {
			map[i] = in.readLine().toCharArray();
		}

		Queue<int[]> walls = new LinkedList<>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == '#')
					walls.offer(new int[] { i, j });
			}
		}
		walls.offer(new int[] { -1, -1 });

		int answer = 0;
		int[] dr = { 0, -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { 0, -1, 0, 1, -1, 1, -1, 0, 1 };
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] { 7, 0 });

		out: while (true) {
			while (!qu.isEmpty()) {
				int[] cur = qu.poll();

				// 욱제가 움직일 수 있는 모든 곳
				for (int d = 0; d < 9; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];

					if (nr < 0 || nc < 0 || nr >= 8 || nc >= 8 || map[nr][nc] == '#')
						continue;
					
					// 탈출 성공
					if (nr == 0 && nc == 7) {
						answer = 1;
						break out;
					}

					map[nr][nc] = '*';
				}
			}
			
			//벽이 없으면 무조건 도달할 수 있다
			if(walls.size() == 1) {
				answer = 1;
				break;
			}

			// 1초 지나면 미로 이동
			while (!walls.isEmpty()) {
				int[] wall = walls.poll();

				if (wall[0] == -1) {
					walls.offer(new int[] { -1, -1 });
					break;
				}
				
				map[wall[0]][wall[1]] = '.';

				if (wall[0] + 1 < 8) {
					map[wall[0] + 1][wall[1]] = '#';
					walls.offer(new int[] { wall[0] + 1, wall[1] });
				}
			}

			// 내려오는 벽이랑 만나지 않을 경우만 큐에 offer
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if (map[i][j] == '*') 
						qu.offer(new int[] { i, j });
				}
			}
			
			if(qu.size() == 0) {
				answer = 0;
				break;
			}
		}

		System.out.println(answer);
	}
}
