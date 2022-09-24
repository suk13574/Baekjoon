import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		int INF = 1000000000;
		
		int[][] floyd = new int[n + 1][n + 1];
		for(int i = 1; i <= n;i++) {
			for(int j = 1 ; j <=n;j++) {
				if(i != j) floyd[i][j] = INF;
			}
		}
		
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			floyd[v][w] = Math.min(floyd[v][w], cost);
		}
		
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (floyd[i][j] == INF) bw.append(0 + " ");
				else bw.append(floyd[i][j] + " ");
			}
			bw.append("\n");
		}
		
		bw.flush();
		bw.close();

	}

}
