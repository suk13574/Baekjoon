import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] matrix = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j = 0 ; j < n ; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        		if(i == 0) {
        			if(j == 0) dp[i][j] = matrix[i][j];
					else dp[i][j] = dp[i][j - 1] + matrix[i][j];
        		}
        		else if(j == 0) {
        			dp[i][j] = dp[i-1][j] + matrix[i][j];
        		}
				else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i][j] - dp[i - 1][j - 1];
				}
        	}
        }

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken()) -1 ;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			if(x1 == 0) {
				if(y1 == 0) System.out.println(dp[x2][y2]);
				else {
					System.out.println(dp[x2][y2] - dp[x2][y1 - 1]);
				}
			}
			else if(y1 == 0) {
				System.out.println(dp[x2][y2] - dp[x1 - 1][y2]);
			}
			else {
				System.out.println(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]);
			}
			
		}
	}

}
