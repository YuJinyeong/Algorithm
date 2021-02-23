import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Q.1202 보석 도둑
public class q1202 {
	static class Jewelry implements Comparable<Jewelry>{
		int weight, price;
		Jewelry(int weight, int price){
			this.weight = weight;
			this.price = price;
		}
		@Override
		public int compareTo(Jewelry o) {
			if(this.weight == o.weight) return o.price- this.price;
			return this.weight - o.weight;
		}
	}
	
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Jewelry[] jew = new Jewelry[N];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			jew[n] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(jew);

		int[] bag = new int[K];
		for(int k=0; k<K; k++) 
			bag[k] = Integer.parseInt(in.readLine());
		Arrays.sort(bag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long total = 0;
		for(int i=0, j=0; i<K; i++) {
			while(j<N && jew[j].weight <= bag[i])
				pq.offer(jew[j++].price);
			
			if(!pq.isEmpty())
				total += pq.poll();
		}
		
		System.out.println(total);
		
	}
}
