import java.io.*;
import java.util.*;

import javax.swing.text.AbstractDocument.LeafElement;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        Stack<long[]> tower = new Stack<>();

        st = new StringTokenizer(bf.readLine());
        for(int i = 1 ; i <= n ; i++){
            long num = Integer.parseInt(st.nextToken());
            
            //스택에서 레이저 수신할 탑 확인하기
            while(!tower.isEmpty()){
                //스택에 있는 탑이 현재 탑의 높이보다 높음 -> 레이저 수신 가능
                if(tower.peek()[0] >= num){
                    bw.write(tower.peek()[1] + " ");
                    break;
                }
                //스택에 있는 탑 현재 탑의 높이보다 낮음 -> 레이저 수신 x
                tower.pop();
            }
            //스택 비어있으면 레이저 수신할 탑 없음
            if(tower.isEmpty()){
                bw.write(0+ " ");
            }

            tower.push(new long[]{num, i});
        }

        bw.flush();
        bw.close();
    }

}