import java.util.*;
public class MovieTitles {
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
		String s = scan.nextLine();
		System.out.println(s + (s.indexOf(" ") >= 0 ? ": Age of Darkness" : " Returns"));
	}
}
