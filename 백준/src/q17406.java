import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Q.17406 배열 돌리기 4
public class q17406 {
	static int N, M, K, A[][], B[][], order[], answer;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static Turn[] Ks;
	static boolean[] check;
	
	
	static class Turn{
		int r, c, s;
		Turn(int r, int c, int s){
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		B = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				B[i][j] = A[i][j];
			}
		}
		
		Ks = new Turn[K];
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			Ks[k] = new Turn(r-1, c-1, s);
		}
		
		answer = Integer.MAX_VALUE;
		//순서 순열로 구하기(->회전 -> 최솟값 구하기)
		check = new boolean[K];
		order = new int[K];
		perm(0);
		
		System.out.println(answer);
		
	}
	
	private static void perm(int idx) {
		if(idx == K) {
			//순서대로 회전하기
			for(int i=0; i<K; i++) {
				Turn t = Ks[order[i]];
				turn(t.r, t.c, t.s);
			}
			//최솟값 구하기
			getMin();
			//B 원래대로 돌려놓기
			turnBack();
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(!check[i]) {
				check[i] = true;
				order[idx] = i;
				perm(idx+1);
				check[i] = false;
			}
		}
	}

	private static void turnBack() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				B[i][j] = A[i][j];
			}
		}
	}

	private static void getMin() {
		for(int n=0; n<N; n++) {
			int sum = 0;
			for(int m=0; m<M; m++) {
				sum += B[n][m];
			}
			answer = Math.min(answer, sum);
		}
	}

	private static void turn(int r, int c, int s) {
		for(int a = s; a>0; a--) {
			int d = 0;
			int sr = r - a, sc = c - a;
			int nr = sr, nc = sc;
			int cur = B[sr][sc];
			while(true) {
				if(d == 3 && nr == sr && nc == sc) //출발점으로 돌아오면 종료
					break;
				
				nr += dr[d];
				nc += dc[d];
				
				//막다른 길을 만나면 방향 전환
				if(nr<r-a || nr>r+a || nc<c-a || nc>c+a) {
					nr -= dr[d];
					nc -= dc[d];
					d++;
					continue;
				}
				
				//값 바꾸기
				int tmp = B[nr][nc];
				B[nr][nc] = cur;
				cur = tmp;
			}
		}
	}
}
