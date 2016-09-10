import java.util.*;
public class WingsAndRedBull {
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
		int dec = scan.nextInt();
		int qq = scan.nextInt();
		int[] dp = new int[n+1];
		Arrays.fill(dp, 1 << 25);
		dp[0] = 0;
		int[] above = new int[dec];
		Arrays.fill(above, 1 << 25);
		int[] all = new int[qq];
		for(int k = 0; k < qq; k++) {
			all[k] = scan.nextInt();
			for(int i = 0; i < dp.length; i++) {
				if(i+all[k] < dp.length) {
					dp[i+all[k]] = Math.min(dp[i+all[k]], dp[i] + 1);
				}
				else if(dec > 0) {
					above[(i+all[k]-n)%above.length] = Math.min(above[(i+all[k]-n)%above.length], dp[i] + 1);
				}
			}
		}
		while(true) {
			boolean upd = false;
			for(int inc: all) {
				for(int i = 0; i < above.length; i++) {
					int next = (i+inc)%above.length;
					if(above[next] > 1 + above[i]) {
						above[next] = 1 + above[i];
						upd = true;
					}
				}
			}
			if(!upd) {
				break;
			}
		}
		System.out.println(dec > 0 ? Math.min(dp[n], above[0]) : dp[n]);
	}

}
