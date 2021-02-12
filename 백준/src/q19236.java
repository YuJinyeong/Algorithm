import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Q.19236 청소년 상어
public class q19236 {
	static class Node{
		int r, c, d;
		Node(int r, int c, int d){
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
		public String toString() {
			return "(" + r + ", " + c + ") " + d;
		}
	}
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	static final int Shark = -1;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[4][4];
		Node[] fishes = new Node[17];
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken())-1;
				map[i][j] = a;
				fishes[a] = new Node(i, j, b);
			}
		}
		
		int ate = 0;
		
		//상어가 0으로 이동
		Node fish = fishes[map[0][0]];
		ate += map[0][0];
		fishes[map[0][0]] = null;
		map[0][0] = Shark; //잡아먹음
		Node shark = new Node(0, 0, fish.d);

		max = 0;
		dfs(fishes, shark, map, ate);
		
		System.out.println(max);
	}
	
	private static void dfs(Node[] bfishes, Node shark, int[][] bmap, int ate) {
		int[][] map = new int[4][4];
		for(int i=0; i<4; i++)
			map[i] = bmap[i].clone();
		
		Node[] fishes = new Node[17];
		for(int i=1; i<fishes.length; i++)
			fishes[i] = bfishes[i];
		
		//물고기 이동
		int nr, nc;
		for(int n=1; n<fishes.length; n++) {
			Node fish = fishes[n];
			if(fish == null) continue;
			int d = fish.d;
			while(true) {
				d%=8;
				
				nr = fish.r + dr[d];
				nc = fish.c + dc[d];
				
				if(nr>=0 && nc>=0 && nr<4 && nc<4 && map[nr][nc] != Shark) {
					if(map[nr][nc] != 0) { //빈칸이 아니면 물고기랑 자리 바꾸기
						Node change = fishes[map[nr][nc]];
						fishes[map[nr][nc]] = new Node(fish.r, fish.c, change.d);
						fishes[n] = new Node(nr, nc, d);
						map[fish.r][fish.c] = map[nr][nc];
						map[nr][nc] = n;
					}else { //빈칸이면 위치만 바뀜
						map[fish.r][fish.c] = 0;
						map[nr][nc] = n;
						fishes[n] = new Node(nr, nc, d);
					}
//					print(map);
					break;
				}
				
				d++;
				if(fish.d == d) { //물고기가 이동할 수 없으면 가만히 있음
					break;
				}
			}
		}
		
//		print(map);
		
		nr = shark.r;
		nc = shark.c;
		boolean flag = false;
		while(true) {
			nr += dr[shark.d];
			nc += dc[shark.d];
			
			if(nr<0 || nc<0 || nr>3 || nc>3)
				break;
			
			if(map[nr][nc] == 0)
				continue;
			
			flag = true;
			int fish_n = map[nr][nc];
			Node fish = fishes[fish_n];
			fishes[fish_n] = null;
			Node s = new Node(nr, nc, fish.d);
			map[s.r][s.c] = -1;
			map[shark.r][shark.c] = 0;
			
//			System.out.println(nr + ", " + nc + ": " + fish_n);
//			System.out.println(fish_n + "먹음 =>" + (fish_n + ate));
			dfs(fishes, s, map, (ate+fish_n));
			
			fishes[fish_n] = fish;
			map[nr][nc] = fish_n;
			map[shark.r][shark.c] = -1;
		}
		
		//잡아 먹을 물고기가 없으면 집으로 돌아가기
		if(!flag) {
			max = Math.max(ate, max);
//			System.out.println("End: " + ate);
			return;
		}
	}

//	private static void print(int[][] map) {
//		System.out.println("=======================");
//		for(int i=0; i<4; i++)
//			System.out.println(Arrays.toString(map[i]));
//	}
}
