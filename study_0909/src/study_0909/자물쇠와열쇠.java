package study_0909;

public class 자물쇠와열쇠 {
	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(solution(key, lock) ? "true" : "false");
	}

	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;
		int N = lock.length;
		int M = key.length;
		int min_r = N, min_c = N, max_r = -1, max_c = -1, cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (lock[i][j] == 0) {
					cnt++;
					min_r = Math.min(min_r, i);
					max_r = Math.max(max_r, i);
					min_c = Math.min(min_c, j);
					max_c = Math.max(max_c, j);
				}
			}
		}
		if(cnt == 0) return true;
		
		int[][] kr90 = new int[M][M];
		int[][] kr180 = new int[M][M];
		int[][] kr270 = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				kr90[i][j] = key[M-1-j][i];
				kr180[i][j] = key[M-1-i][M-1-j];
				kr270[i][j] = key[j][M-1-i];
			}
		}

		int rl=-1, cl=-1, rk=-1, ck=-1, ti=0, tj=0;
		for (int i = 0; i < M - (max_r - min_r); i++) {
			for (int j = 0; j < M - (max_c - min_c); j++) {
				if(key[i][j] + lock[min_r][min_c] == 1) {
					boolean flag = true;
					out: for (rl = min_r, rk = i; rl < max_r + 1; rl++, rk++) {
						for (cl = min_c, ck = j; cl < max_c + 1; cl++, ck++) {
//							System.out.println("key[" + rk + "][" + ck + "], lock[" + rl +  "][" + cl + "]");
							if(rk>=M || ck>=M || lock[rl][cl]+key[rk][ck] != 1) {
								flag = false;
//								System.out.println("0 fail");
								break out;
							}
						}
					}
					if(flag) return flag;
				}
				// 90도 회전해서 비교
				if(kr90[i][j] + lock[min_r][min_c] == 1) {
					boolean flag = true;
					out: for (rl = min_r, rk = i; rl < max_r + 1; rl++, rk++) {
						for (cl = min_c, ck = j; cl < max_c + 1; cl++, ck++) {
//							System.out.println("key[" + rk + "][" + ck + "], lock[" + rl +  "][" + cl + "]");
							if(rk>=M || ck>=M || lock[rl][cl]+kr90[rk][ck] != 1) {
								flag = false;
//								System.out.println("90 fail");
								break out;
							}
						}
					}
					if(flag) return flag;
				}
				// 180도 회전해서 비교
				if(kr180[i][j] + lock[min_r][min_c] == 1) {
					boolean flag = true;
					ti = i; tj = j;
					out: for (rl = min_r, rk = i; rl <= max_r; rl++, rk++) {
						for (cl = min_c, ck = j; cl <= max_c; cl++, ck++) {
//							System.out.println("key[" + rk + "][" + ck + "], lock[" + rl +  "][" + cl + "]");
							if(rk>=M || ck>=M || lock[rl][cl]+kr180[rk][ck] != 1) {
								flag = false;
//								System.out.println("180 fail");
								break out;
							}
						}
					}
					if(flag) return flag;
				}
				// 270도 회전해서 비교
				if(kr270[i][j] + lock[min_r][min_c] == 1) {
					boolean flag = true;
					out: for (rl = min_r, rk = i; rl < max_r + 1; rl++, rk++) {
						for (cl = min_c, ck = j; cl < max_c + 1; cl++, ck++) {
//							System.out.println("key[" + rk + "][" + ck + "], lock[" + rl +  "][" + cl + "]");
							if(rk>=M || ck>=M || lock[rl][cl]+kr270[rk][ck] != 1) {
								flag = false;
//								System.out.println("270 fail");
								break out;
							}
						}
					}
					if(flag) return flag;
				}
			}
		}
		return false;
	}
}
