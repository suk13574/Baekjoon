import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int[][] dp = new int[n+1][3];
		

		for (int i = 1; i <= n; i++) {
			int score = Integer.parseInt(bf.readLine());
			// 1. 현재 계단 밟지 않음
			dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]);

			// 2. 현재 계단 밟음 - 1계단 전에서 올라옴
			dp[i][1] = dp[i - 1][2] + score;

			// 3. 현재 계단 밟음 - 2계단 전에서 올라옴
			dp[i][2] = dp[i - 1][0] + score;
		}
		System.out.println(Math.max(dp[n][1],dp[n][2]));
	}
}
