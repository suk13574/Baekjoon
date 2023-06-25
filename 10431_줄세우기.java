import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(bf.readLine());

        int[] student;
        int answer = 0;

        for(int n = 0; n < num; n++){
            student = new int[20];
            answer = 0;

            String line = bf.readLine();
            st = new StringTokenizer(line, " ");
            bw.write(st.nextToken() + " ");

            for(int i = 0; i < 20; i++){
                student[i] = Integer.parseInt(st.nextToken());
                
            }
            for(int i = 0 ; i < student.length; i ++){
                for(int j = 0; j < i; j++) {
                    if(student[j] > student[i]) answer++;
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
