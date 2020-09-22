import java.util.Arrays;
import java.util.Scanner;

public class q2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] height = new int[9];
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}
		
		Arrays.sort(height);
		
		out: for(int i=0; i<9; i++) {
			for(int j=0; j<i; j++) {
				if(height[i] + height[j] == (sum - 100)) {
					for(int h=0; h<9; h++) {
						if(h != i && h != j)
							System.out.println(height[h]);
					}
					break out;
				}
			}
		}
	}

}
