import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //그래프 선언
        List<Node>[] graph = new ArrayList[n+1];
        for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

        //그래프 입력받기
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w  = Integer.parseInt(st.nextToken());

            graph[v1].add(new Node(v2, w));
            graph[v2].add(new Node(v1, w));
        }
        int answer = Dijkstra(graph);
        System.out.println(answer);
    }

    //다익스트라
    public static int Dijkstra(List<Node>[] graph){
        //정점 1에서 각 노드까지 최단거리
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //방문 체크
        boolean[] check = new boolean[graph.length];

        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            int now = pq.poll().v;

            if(check[now]) continue;
            check[now] = true;

            for(Node node : graph[now]) {
                if(dist[node.v] > dist[now] + node.w) {
                    dist[node.v] = dist[now] + node.w;

                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }

        return dist[graph.length - 1];

    }

    //그래프 저장 객체
    static class Node implements Comparable<Node>{
        int v;
        int w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Main.Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

}