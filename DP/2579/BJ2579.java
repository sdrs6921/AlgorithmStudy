import java.util.Scanner;

public class BJ2579 {
	
	public static void main(String[] args) {
		//dp[i] = max(계단점수[i] + dp[i-2], 계단점수[i] + 계단점수[i-1] +dp[i-3])
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] stair = new int[n];
		int[] dp = new int[n];
		
		for (int i = 0; i < stair.length; i++) {
			stair[i] = scan.nextInt();
		}
		
		for (int i = 0; i < dp.length; i++) {
			if (i ==0) {
				dp[i] = stair[i];
			} else if (i == 1) {
				dp[i] = stair[i] + dp[i - 1];
			} else if (i == 2) {
				dp[i] = Math.max(stair[i] + stair[i-2], stair[i] + stair[i-1]);
			} else {
				dp[i] = Math.max(stair[i] + dp[i-2], stair[i] + stair[i-1] + dp[i - 3]);
			}
		}
		
		for (int i : dp) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(dp[dp.length - 1]);
	}
}