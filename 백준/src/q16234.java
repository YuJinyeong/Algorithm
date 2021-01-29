import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.16234 인구 이동
public class q16234 {
	static int N, L, R, A[][], answer, people, count, B[][], union, map[][];
	static boolean[][] check;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		boolean flag = false;
		while(!flag) {
			
			//국경선 열기
			check = new boolean[N][N];
			B = new int[N][N];
			union = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!check[i][j]) 
						unite(i, j, ++union);
				}
			}
			
			//연합 별 국가의 수와 인구 수 조사
			map = new int[union+1][2];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[B[i][j]][0]++; //연합 한 국가의 수
					map[B[i][j]][1] += A[i][j]; //연합 별 인구 수의 합
				}
			}
			
			//인구 이동
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					result = map[B[i][j]][1] / map[B[i][j]][0];
					if(A[i][j] == result) count++;
					else A[i][j] = result;
				}
			}
			
			answer++;
			
			if(count == N*N)
				break;
			
		}
		System.out.println(answer-1);
	}
	static int cur[], nr, nc, result;
	private static void unite(int r, int c, int v) {
		Queue<int[]> qu = new LinkedList<>();
		check[r][c] = true;
		B[r][c] = v;
		qu.add(new int[] {r, c});
		
		while(!qu.isEmpty()) {
			cur = qu.poll();
			for(int d=0; d<4; d++) {
				nr = cur[0] + dr[d];
				nc = cur[1] + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || check[nr][nc])
					continue;
				
				result = Math.abs(A[nr][nc] - A[cur[0]][cur[1]]);
				
				if(result >= L && result <= R) {
					check[nr][nc] = true;
					B[nr][nc] = v;
					qu.add(new int[] {nr, nc});
				}
			}
		}
	}
}
