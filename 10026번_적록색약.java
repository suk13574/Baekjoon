import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		String[][] grid = new String[n][];
		for(int i = 0 ; i < n ; i++) {
			String str = bf.readLine();
			grid[i] = str.split("");
		}
		visit = new boolean[n][n];
		
		count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j]) bfs(grid, i, j, 0);
			}
		}
		System.out.print(count+" ");
		
		count = 0;
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j]) bfs(grid, i, j, 1);
			}
		}
		System.out.print(count);
		
	}
	static boolean[][] visit;
	static int count;
	
	public static void bfs(String[][] grid, int i, int j, int check) {
		int[][] around = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		visit[i][j] = true;
		String color = grid[i][j];
		count++;
		
		if(check == 1 && !color.equals("B")) {
			color = "RG";
		}
		
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int k = 0 ; k < 4; k++) {
				int x = temp[0] + around[k][0];
				int y = temp[1] + around[k][1];
				
				if (x >= 0 && y >= 0 && x < grid.length && y < grid.length) {
					if (!visit[x][y] && color.contains(grid[x][y])) {
						q.add(new int[] {x, y});
						visit[x][y] = true;
					}
				}
			}
		}
	}
	
	
}
