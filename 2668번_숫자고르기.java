import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list;
    static boolean[] visit;
    static int[] num;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        num = new int[n + 1];
        for(int i = 1; i <= n; i++){
            num[i] = Integer.parseInt(bf.readLine());
        }

        // 1~n 하나씩 사이클을 생성하는지 dfs로 확인
        list = new ArrayList<>();
        visit = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        System.out.println(list.size());
        list.stream()
            .sorted()
            .forEach(x -> System.out.println(x));

    }

    static void dfs(int start, int target){
        //현재 방문하려는 노드 방문하지 않았다면
        if(!visit[num[start]]){
            visit[num[start]] = true;
            dfs(num[start], target);
            visit[num[start]] = false;
        }

        //사이클 발생하는지 확인
        if(num[start] == target) list.add(target);
    }

}