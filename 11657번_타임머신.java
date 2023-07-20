import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node> bus = new ArrayList<>();

        /* 버스 경로 입력 */
        for(int i = 0; i < m;i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            //도착지, 가중치 순으로 추가
            bus.add(new Node(v1, v2, w));
            
        }

        /* 벨만 포드 알고리즘 */
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; //출발지 지역 1

        for(int i = 0 ; i <= n ; i++){
            for (int j = 0; j < m; j++) {
                Node node = bus.get(j);
                // v1까지 가는 길 무한이 아니고
                // v1을 경유해서 v2 가는 것이 더 빠르다면 갱신
                if(dist[node.v1] != INF && dist[node.v2] > (dist[node.v1] + node.cost)) {
                    dist[node.v2] = dist[node.v1] + node.cost;

                    //n+1번째 갱신이 있다면 음수 사이클 존재
                    if(i == n) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        /* 결과 출력 */
        for(int i = 2; i < dist.length; i++){
            System.out.println((dist[i] == INF)?-1:dist[i]);
        }

    }

    static class Node {
        int v1;
        int v2;
        int cost;
        
        public Node(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

}