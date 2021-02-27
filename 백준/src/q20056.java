import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//Q.20056 마법사 상어와 파이어볼
public class q20056 {
	static class Fireball implements Comparable<Fireball>{
		int r, c, m, s, d;
		Fireball(int r, int c, int m, int s, int d){
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		@Override
		public int compareTo(Fireball o) {
			if(this.r == o.r)
				return this.c - o.c;
			return this.r - o.r;
		}
		@Override
		public String toString() {
			return "(" + r + ", " + c + ") m: " + m + ", s: " + s + ", d: " + d;
		}
	}
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N, M, K, map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		Queue<Fireball> qu = new LinkedList<>();
		int r, c, m, s, d;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			qu.add(new Fireball(r, c, m, s, d));
		}
		
		for(int k=0; k<K; k++) {
			PriorityQueue<Fireball> pq = new PriorityQueue<>();
			
			//Fireball 이동
			while(!qu.isEmpty()) {
				Fireball cur = qu.poll();
//				System.out.print(cur.toString() + " ====> ");
				cur.r = (cur.r + dr[cur.d] * cur.s)%N;
				if(cur.r < 0) cur.r += N;
				cur.c = (cur.c + dc[cur.d] * cur.s)%N;
				if(cur.c < 0) cur.c += N;
//				System.out.println(cur.toString());
				pq.offer(cur);
			}
			
			while(!pq.isEmpty()) {
				Fireball cur = pq.poll();
//				System.out.println(cur.r + ", " + cur.c);
//				System.out.println(cur.toString());
				m = cur.m;
				d = cur.d;
				s = cur.s;
				int cnt = 1;
				int check = d % 2; //1은 홀수, 0는 짝수
				boolean isSame = true; //모두 홀수냐 모두 짝수냐
				while(!pq.isEmpty()) {
					if(pq.peek().r != cur.r || pq.peek().c != cur.c)
						break;
					
					Fireball nxt = pq.poll();
//					System.out.println("같은 곳인 Fireball )))) " + nxt.toString());
					cnt++;
					m += nxt.m;
					s += nxt.s;
					if(!isSame)	continue;
					if(nxt.d % 2 != check) {
						isSame = false;
					}
				}
				
				if(cnt == 1) {
					qu.add(cur);
//					System.out.println("한 개라 그냥 그대로 들어감");
					continue;
				}
				
				if(m<5) continue; //질량이 0인 Fireball은 소멸
				
				//2개 이상이면 나눠져야 함
				m /= 5;
				s /= cnt;
				int start = isSame? 0 : 1;
				for(int dir=start; dir<8; dir+=2) {
					Fireball newOne = new Fireball(cur.r, cur.c, m, s, dir);
//					System.out.println(newOne.toString() + " 으로 나눠졌음");
					qu.offer(newOne);
				}
			}
		}
		
		//남아있는 질량의 합 출력
		int sum = 0;
		while(!qu.isEmpty()) {
			sum += qu.poll().m;
		}
		System.out.println(sum);
		
	}
}
