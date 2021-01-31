import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.16236 아기상어
public class q16236 {
	static int fishes = 0; // 물고기 수
	static int cnt = 0; // 먹은 물고기 수
	static int total = 0; // 총 시간
	static int N, R, C, S, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					R = i;
					C = j;
					S = 2;
				} else if (map[i][j] != 0) {
					fishes++;
				}
			}
		}

		total = 0;
		while(true) {
			// 먹을 수 있는 물고기가 없으면 엄마 상어에게 도움 요청
			if (fishes == 0 || !find())
				break;
		}
			
		System.out.println(total);
	}

	private static boolean find() {
		boolean[][] check = new boolean[N][N];
		Queue<int[]> qu = new LinkedList<>();
		List<int[]> finds = new ArrayList<>();

		check[R][C] = true;
		map[R][C] = 0;
		qu.offer(new int[] { R, C, 0 });
		int time = 123456789;
		
		while (!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			if(cur[2] > time)
				continue;
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				// 공간을 벗어나거나 방문했던 곳이면 탈락
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || check[nr][nc])
					continue;
				
				if (map[nr][nc] == 0 || map[nr][nc] == S) {
					check[nr][nc] = true;
					qu.offer(new int[] { nr, nc, cur[2] + 1 });
				} else if (map[nr][nc] < S) {// 물고기를 잡아먹음
					time = cur[2] + 1;
					check[nr][nc] = true;
					finds.add(new int[] {nr, nc, time});
				}
			}
		}
		
		if(finds.size() < 1)
			return false;
		else {
			int[] f = finds.get(0);
			for(int[] fish : finds) {
				if(fish[2] == f[2]) {
					if(fish[0] < f[0]) {
						f = fish;
					}
				}else if(fish[2] < f[2]) {
					f = fish;
				}
			}
			
			fishes--; //전체 물고기 수 감수
			if (++cnt == S) {// 먹은 물고기 수랑 아기 상어 크기 증가
				cnt = 0;
				S++;
			}
			
			//아기 상어 이동
			map[f[0]][f[1]] = 0;
			R = f[0];
			C = f[1];
			total += f[2]; //찾고 먹는데 걸린 시간
			return true;
		}
	}
}
