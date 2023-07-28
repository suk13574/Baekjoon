import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 100001;
        int max = 100001;

        Queue<Location> q = new LinkedList<>();
        boolean[] visit = new boolean[max];

        //bfs
        q.add(new Location(n, 0));

        while(!q.isEmpty()){
            Location now = q.poll();
            visit[now.x] = true;
            if(now.x == k)  answer = Math.min(answer, now.time);

            //순간이동 - q 순서대로 뽑아서 방문 체크 하므로 순간이동 부터 조건 확인
            if(now.x * 2 < max && !visit[now.x * 2]){
                q.add(new Location(now.x * 2, now.time));
            }
            //x-1 이동
            if(now.x - 1 >= 0 && !visit[now.x - 1]) {
                q.add(new Location(now.x - 1, now.time + 1));
            }
            //x+1 이동
            if(now.x + 1 < max && !visit[now.x + 1]) {
                q.add(new Location(now.x + 1, now.time + 1));
            }
        }

        System.out.println(answer);

    }

    static class Location{
        int x;
        int time;

        public Location(int x, int time){
            this.x = x;
            this.time = time;
        }
    }

}