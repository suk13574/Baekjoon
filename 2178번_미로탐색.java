import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String temp = bf.readLine();
		String[] str = temp.split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] maze = new int[n][m];

		for (int i = 0; i < n; i++) {
			temp = bf.readLine();
			str = temp.split("");
			for (int j = 0; j < str.length; j++) {
				maze[i][j] = Integer.parseInt(str[j]);
			}
		}
		boolean[][] visit = new boolean[n][m];
		bfs(maze, visit, 0, 0);
	}
	
	static int answer;
	public static void bfs(int[][] maze, boolean[][] visit, int i, int j) {
		int[][] move = new int[][] {
				{1, 0}, {-1, 0}, {0, 1}, {0,-1}
		};
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{i, j, 1});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			if (temp[0] == maze.length - 1 && temp[1] == maze[0].length - 1) {
				System.out.println(temp[2]);
				break;
			}
			
			for(int k = 0; k < 4; k++) {
				int x = temp[0] + move[k][0];
				int y = temp[1] + move[k][1];
				if(x >= 0 && y >= 0 && x < maze.length&&y<maze[0].length) {
					if(!visit[x][y] && maze[x][y] == 1) {
						visit[x][y] = true;
						q.add(new int[] {x, y, temp[2] + 1});
					}
				}
			}
		}
	}
}
