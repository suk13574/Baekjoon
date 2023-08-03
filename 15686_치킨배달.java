import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            String line = br.readLine();
            String[] street = line.split(" ");
            for(int j = 0 ; j < street.length; j++){
                if(street[j].equals("1")) home.add(new Node(i, j));
                if(street[j].equals("2")) chicken.add(new Node(i, j));
            }
        }
        visit = new boolean[chicken.size()];

        answer = Integer.MAX_VALUE;
        com(0, 0);

        System.out.println(answer);

    } // End of main 

    static int n;
    static int m;
    static List<Node> home;
    static List<Node> chicken;

    static boolean[] visit;
    static int answer;

    static void com(int start, int count){
        //m개 치킨집 다 고름
        if(count == m){
            int chickenStreet = 0; //도시의 치킨 거리

            for(int i = 0; i < home.size(); i++){
                int distance = Integer.MAX_VALUE;

                for(int j = 0; j < chicken.size(); j++){
                    if(visit[j]){
                        int temp = Math.abs(home.get(i).x - chicken.get(j).x)
                                + Math.abs(home.get(i).y - chicken.get(j).y);
                        
                        distance = Math.min(distance, temp);
                    }
                }

                chickenStreet+= distance;
            }

            answer = Math.min(answer, chickenStreet);

        }

        //치킨집 고름
        for(int i = start; i < chicken.size(); i++){
            if(!visit[i]){
                visit[i] = true;
                com(i + 1, count + 1);
                visit[i] = false;
            }
        }

        
    } // End of com

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    } // End of Node Class

} // End of Main Class