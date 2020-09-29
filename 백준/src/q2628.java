import java.util.Arrays;
import java.util.Scanner;

public class q2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int n = sc.nextInt();
		
		int dr[] = new int[n];
		int dc[] = new int[n];
		int dr_idx=0, dc_idx=0;
		
		for(int i=0; i<n; i++) {
			int d = sc.nextInt();
			int num = sc.nextInt();
			if(d==0) {
				dr[dr_idx++] = num;
			}else {
				dc[dc_idx++] = num;
			}
		}
		
		Arrays.sort(dr);
		Arrays.sort(dc);
		
		int mw=0, mh=0;
		int sw=0, sh=0;
		for(int i=n-dr_idx; i<n; i++) {
//			System.out.println("h: " + (dr[i]-sh));
			mh = Math.max(mh, dr[i]-sh);
			sh = dr[i];
		}
		mh = Math.max(mh, h-sh);
//		System.out.println("h: " + (h-sh));
		
		for(int i=n-dc_idx; i<n; i++) {
//			System.out.println("w: " + (dc[i]-sw));
			mw = Math.max(mw, dc[i]-sw);
			sw = dc[i];
		}
		mw = Math.max(mw, w-sw);
//		System.out.println("w: " + (w-sw));
		
//		System.out.println("mw: " + mw);
//		System.out.println("mh: " + mh);
		System.out.println(mw*mh);
		
	}
}
