import java.util.*;
public class PartyTime {
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
		int[] x = new int[n+1];
		int[] y = new int[n+1];
		for(int i = 0; i <= n; i++) {
			x[i] = scan.nextInt();
			y[i] = scan.nextInt();
		}
		Arrays.sort(x);
		Arrays.sort(y);
		System.out.println(x[n/2] + " " + y[n/2]);
	}
}
