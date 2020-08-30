
public class 부분집합 {
	static int[] arr = {1, 3, 5};
	static int N = arr.length;
	static boolean[] check = new boolean[N];

	private static void powerSet(int idx) {
		if(idx == N) {
			for(int i=0; i<N; i++) {
				if(check[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		check[idx] = true;
		powerSet(idx + 1);
		
		check[idx] = false;
		powerSet(idx + 1);
		
	}
	
	public static void main(String[] args) {
		powerSet(0);
	}

}
