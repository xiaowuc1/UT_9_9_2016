import java.util.*;
public class PersonalSpace {
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
		int[] list = new int[n];
		int[] move = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = scan.nextInt();
		}
		Arrays.sort(list);
		while(true) {
			boolean upd = false;
			int[] wantMove = new int[n];
			Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
			for(int i = 0; i + 1 < n; i++) {
				if(list[i] + 1 == list[i+1] && (i == 0 || list[i] - 1 > list[i-1])) {
					wantMove[i] = -1;
				}
				if(list[i] + 1 == list[i+1] && (i + 2 == n || list[i+1] + 1 < list[i+2])) {
					wantMove[i+1] = 1;
				}
			}
			for(int i = 0; i < wantMove.length; i++) {
				if(wantMove[i] == 0) continue;
				if(!dp.containsKey(list[i] + wantMove[i])) {
					dp.put(list[i] + wantMove[i], 0);
				}
				dp.put(list[i] + wantMove[i], 1 + dp.get(list[i] + wantMove[i]));
			}
			for(int i = 0; i < wantMove.length; i++) {
				if(wantMove[i] == 0) continue;
				if(dp.get(list[i] + wantMove[i]) == 1) {
					list[i] += wantMove[i];
					move[i] += wantMove[i];
					upd = true;
				}
			}
			if(!upd) {
				break;
			}
		}
		int ret = 0;
		for(int out: move) {
			ret = Math.max(ret, Math.abs(out));
		}
		System.out.println(ret);
	}

}
