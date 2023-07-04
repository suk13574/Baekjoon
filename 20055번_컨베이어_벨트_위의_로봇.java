import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int n;
    static LinkedList<Belt> conveyor;
    static boolean[] robot;
    static int step = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int size = 2 * n;
        conveyor = new LinkedList<>();
        robot = new boolean[size];

        String[] durability = bf.readLine().split(" ");
        for(int i = 0; i < size; i++){
            conveyor.add(i, new Belt(Integer.parseInt(durability[i])));              
        }

        while(k > 0) {
            MoveConveyor();
            MoveRobot();
        }

        bw.write(step+ "");
        bw.flush();
        bw.close();
    }

    //컨베이어 벨트 이동
    static void MoveConveyor(){
        step++;
        conveyor.add(0, conveyor.removeLast());
        if(conveyor.get(n - 1).robot) conveyor.get(n - 1).robot = false;
    }

    //로봇이동
    static void MoveRobot(){

        for(int i = n - 1; i > 0; i--){
            //벨트위에 로봇 없으면 패스
            if(!conveyor.get(i).robot) continue;

            //다음 벨트에 로봇 있거나 내구도 0이면 이동 불가
            if(conveyor.get(i + 1).robot == true || conveyor.get(i+1).durability <=0) continue;

            //로봇 다음 칸으로 이동, 내구도 깎기
            conveyor.get(i).robot = false;
            conveyor.get(i+1).putRobot();
            if(conveyor.get(i+1).durability <= 0) k--;

            //내리는 위치로 로봇 이동했다면 로봇 내리기
            if(i + 1 == n - 1) conveyor.get(i + 1).robot = false;
        }

        //올리는 위치에 내구도 1 이상이면 로봇 올림
        if(conveyor.get(0).durability > 0) {
            conveyor.get(0).putRobot();
            if(conveyor.get(0).durability <= 0) k--;
        }

        //컨베이어 벨트 내구도 0 이하인 개수가 k개 이상이면 false 반환
    }

    static class Belt{
        int durability;
        boolean robot;

        public Belt(int durability){
            this.durability = durability;
            robot = false;
        }

        public void putRobot(){
            robot = true;
            durability--;
        }

    }

}
