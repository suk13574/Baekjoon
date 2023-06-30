import java.io.*;
import java.util.*;

public class Main {
    static char[][] before;
    static char[] after;
    static int n;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        before = new char[2][n];

        before[0] = bf.readLine().toCharArray();
        before[1] = before[0].clone();
        
        after = bf.readLine().toCharArray();

        greddy(0, 1, 0);

        turnOnOff(1, 0);
        greddy(1, 1, 1);
        
        bw.write(((answer==Integer.MAX_VALUE)?-1:answer)+"");

        bw.flush();
        bw.close();
    }

    static void greddy(int now, int idx, int count){
        if(idx == n) {
            if(before[now][idx-1] == after[idx-1]) answer = Math.min(answer, count);
        } else{
            if(before[now][idx - 1] != after[idx - 1]) {
                turnOnOff(now, idx);
                greddy(now, idx + 1, count + 1);
            }
            else {
                greddy(now, idx + 1, count);
            }
        }
    }

    static void turnOnOff(int now, int idx){
        for(int i = idx - 1; i <= idx + 1; i++){
            if(i >= 0 && i < n){
                before[now][i] = before[now][i]=='0'?'1':'0';
            }
        }
    }
}
