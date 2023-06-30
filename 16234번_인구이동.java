import java.io.*;
import java.util.*;

public class Main {
    static int[][] world;
    static int n;
    static int L;
    static int R;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        world = new int[n][n];

        for(int i = 0; i < n; i++){
            world[i] = Arrays.stream(bf.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }

        int answer = 0;
        while(true){
            boolean isMove = false;
            boolean[][] visit = new boolean[n][n];

            for(int i = 0 ; i < n; i++){
                for (int j = 0; j < n; j++){
                    if(!visit[i][j]){
                        int sum = bfs(visit, i, j);
                        if(list.size() > 1){
                            movePeople(sum / list.size());
                            isMove = true;
                        }
                    }
                }
            }

            if(!isMove) break;
            answer++;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
    
    static int[][] moves = new int[][]{
        {1, 0},{-1, 0},{0, 1},{0, -1}
    };
    static ArrayList<int[]> list;

    //bfs로 연합 확인
    static int bfs(boolean[][] visit, int x, int y){

        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();

        q.add(new int[]{x, y});
        list.add(new int[]{x, y});
        visit[x][y] = true;
        int sum = world[x][y];


        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int[] move : moves){
                int nextX = now[0] + move[0];
                int nextY = now[1] + move[1];

                if(nextX >= 0 && nextX < n && nextY >=0 && nextY < n) {
                    if(!visit[nextX][nextY]){
                        int gap = Math.abs(world[now[0]][now[1]] - world[nextX][nextY]);
                        if(gap >= L && gap <= R){
                            visit[nextX][nextY] = true;
                            q.add(new int[]{nextX, nextY});
                            list.add(new int[]{nextX, nextY});
                            sum += world[nextX][nextY];
                        }
                    }
                }
            }

        } //bfs 종료

        return sum;
    }

    //인구 이동
    static public void movePeople(int change){
        for(int[] w : list){
            world[w[0]][w[1]] = change;
        }
    }

}