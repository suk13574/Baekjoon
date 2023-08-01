import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheese++;
            }
        }

        int lastCheese = 0;
        int time = 0;
        while(cheese != 0) {
            visit = new boolean[n][m]; //방문 체크 초기화
            lastCheese = cheese; //마지막 치즈 개수 갱신
            time++; 

            DFS(0, 0); //DFS
        }

        bw.write(time + "\n" + lastCheese);
        

        bw.flush();
        bw.close();
    } // End of main 

    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int cheese = 0;

    static int[][] moves = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static void DFS(int x, int y){
        visit[x][y] = true;

        for(int[] move : moves){
            int nowX = x + move[0];
            int nowY = y + move[1];

            //범위 체크
            if(nowX < 0 || nowY < 0 || nowX >= n || nowY >= m) continue;

            //치즈 있으면 0으로 변경
            if(!visit[nowX][nowY] && map[nowX][nowY] == 1) {
                map[nowX][nowY] = 0;
                visit[nowX][nowY] = true;
                cheese--;
            }

            //공기면 DFS 실행
            if(!visit[nowX][nowY] && map[nowX][nowY] == 0) {
                visit[nowX][nowY] = true;
                DFS(nowX, nowY);
            }

        }

    } // End of DFS
} // End of Main Class