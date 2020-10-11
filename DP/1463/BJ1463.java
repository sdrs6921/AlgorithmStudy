import java.util.Scanner;

public class BJ1463 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] dp = new int[n];
		
		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i-1] + 1;
			
			if ((i + 1) % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
			if ((i + 1) % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
		}
		
		System.out.println(dp[dp.length - 1]);
	}
}