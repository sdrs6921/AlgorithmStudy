import java.util.Scanner;

public class BJ1149 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] cost = new int[n][3];
		int[][] dp = new int[n][3];
		int answer;
		
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[i].length; j++) {
				cost[i][j] = scan.nextInt();
			}
		}
		
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = cost[0][i];
		}
		
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		for (int[] i : dp) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
	}
}