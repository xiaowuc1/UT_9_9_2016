import java.util.*;
public class HappyNewYear {
	static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int qq = scan.nextInt();
		while(qq-- > 0) {
			solve();
		}
	}
	public static void solve() {
		int n = scan.nextInt();
		int e = scan.nextInt();
		int[][] dist = new int[n][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(dist[i], 1 << 25);
			dist[i][i] = 0;
		}
		while(e-- > 0) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			dist[a][b] = Math.min(dist[a][b], 1);
		}
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		int ret = 0;
		for(int s1 = 0; s1 < n; s1++) {
			for(int s2 = 0; s2 < n; s2++) {
				int best = Integer.MAX_VALUE;
				for(int d = 0; d < n; d++) {
					best = Math.min(best, Math.max(dist[s1][d], dist[s2][d]));
				}
				ret = Math.max(ret, best);
			}
		}
		System.out.println(ret >= (1<<25) ? "IMPOSSIBLE" : ret);
	}
}
