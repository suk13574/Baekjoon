import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] maze = new char[r][c];
        int[][] dist1 = new int[r][c];
        int[][] dist2 = new int[r][c];
        Queue<int[]> fire = new LinkedList<>();
        Queue<int[]> person = new LinkedList<>();

        //미로 입력
        for(int i = 0; i < r; i++){
            maze[i] = bf.readLine().toCharArray();

            for(int j = 0;j < c; j++){
                dist1[i][j] = -1;
                dist2[i][j] = -1;
                
                if(maze[i][j] == 'J'){
                    dist2[i][j] = 0;
                    person.add(new int[]{i, j});
                }
                else if(maze[i][j] == 'F'){
                    dist1[i][j] = 0;
                    fire.add(new int[]{i, j});
                }
            }
        }
        int[][] moves = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
        };
        //fire bfs
        while(!fire.isEmpty()){
            int[] now = fire.poll();

            for(int[] move : moves){
                int nx = now[0] + move[0];
                int ny = now[1] + move[1];

                //범위 넘어가면 패스
                if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

                //벽이거나 발화 시작점이면 패스
                if(maze[nx][ny] == '#' || maze[nx][ny] == 'F') continue;

                //이미 불이 번졌다면 패스
                if(dist1[nx][ny] >= 1) continue;

                dist1[nx][ny] = dist1[now[0]][now[1]] + 1;
                fire.add(new int[]{nx, ny});
            }
        }

        //person bfs
        while(!person.isEmpty()){
            int[] now = person.poll();

            for(int[] move : moves){
                int nx = now[0] + move[0];
                int ny = now[1] + move[1];

                //범위 넘어가면 탈출
                if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    System.out.println(dist2[now[0]][now[1]] + 1);
                    return;
                }

                //이미 방문한 곳은 패스
                if(dist2[nx][ny] >= 1) continue;

                //벽이거나 갈 수 없으면 패스
                if(maze[nx][ny] == '#' || maze[nx][ny] != '.') continue;

                //이미 불이 번진 길이면 패스
                if(dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[now[0]][now[1]] + 1) continue;

                dist2[nx][ny] = dist2[now[0]][now[1]] + 1;
                person.add(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");

    }

}