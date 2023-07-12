import java.io.*;
import java.util.*;

public class Main {
    static int[][] moves = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }

        boolean[][][] visit = new boolean[n][m][2];

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0, 1, false)); //x, y, 이동거리, 벽 부순 경우

        while(!q.isEmpty()) {
            Loc now = q.poll();
            if(now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.dist);
                return;
            }

            for(int[] move : moves){
                int nx = now.x + move[0];
                int ny = now.y + move[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 벽 아니면
                if(map[nx][ny] == 0) {
                    if(!visit[nx][ny][0] && !now.destroy) { //벽 부신적 없음
                        q.add(new Loc(nx, ny, now.dist + 1, false));
                        visit[nx][ny][0] = true;
                    }
                    else if(!visit[nx][ny][1] && now.destroy) { //벽 부신적 있음
                        q.add(new Loc(nx, ny, now.dist + 1, true));
                        visit[nx][ny][1] = true;
                    }
                }
                // 벽이면
                else {
                    //이전까지 부신적 없다면 부심
                    if(!visit[nx][ny][1] && !now.destroy){
                        q.add(new Loc(nx, ny, now.dist + 1, true));
                        visit[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);

    }

    static class Loc {
        int x;
        int y;
        int dist;
        boolean destroy;

        public Loc(int x, int y, int dist, boolean destroy){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.destroy = destroy;
        }
    }


}