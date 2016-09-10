import java.util.*;
public class Terminated {
	static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int qq = scan.nextInt();
		scan.nextLine();
		while(qq-- > 0) {
			solve();
		}
	}
	public static void solve() {
		int n = scan.nextInt();
		int y = scan.nextInt() + n/2;
		int x = n/2 - scan.nextInt();
		scan.nextLine();
		char[][] grid = new char[n][];
		for(int i = 0; i < n; i++) {
			grid[i] = scan.nextLine().toCharArray();
		}
		boolean[][] reachable = new boolean[n][n];
		reachable[n/2][n/2] = true;
		for(int time = 1; !reachable[x][y]; time++) {
			boolean[][] next = new boolean[n][n];
			int seen = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!reachable[i][j]) continue;
					seen++;
					for(int dx = -1; dx <= 1; dx++) {
						for(int dy = -1; dy <= 1; dy++) {
							int nx = i + dx;
							int ny = j + dy;
							if(Math.min(nx, ny) < 0 || Math.max(nx, ny) >= n) continue;
							if(Math.max(ny, Math.abs(n/2 - nx)) <= time) continue;
							if(grid[nx][ny] == '#') continue;
							next[nx][ny] = true;
						}
					}
				}
			}
			if(seen == 0) {
				break;
			}
			reachable = next;
		}
		System.out.println(reachable[x][y] ? "ESCAPED" : "TERMINATED");
	}
}
