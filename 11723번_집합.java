import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] numbers = new int[21];
        int n  = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < n ; i++){
            String str = bf.readLine();
            st = new StringTokenizer(str, " ");
            
            String oper = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            switch(oper) {
                case "add": numbers[num] = 1; break;
                case "remove": numbers[num] = 0; break;
                case "check": bw.write(numbers[num] + "\n"); break;
                case "toggle": numbers[num] = (numbers[num]==1)?0:1; break;
                case "all": Arrays.fill(numbers, 1); break;
                case "empty": Arrays.fill(numbers, 0); break;
            }
        }


        bw.flush();
        bw.close();
    }


}