import java.io.*;
import java.util.*;

public class Main {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = bf.readLine().toUpperCase();

        int[] arr = new int[26];
        int max = -1;
        int idx = 0;
        char answer = '?';

        for(int i = 0; i < str.length(); i++){
            idx = str.charAt(i) - 65;
            arr[idx]++;
            if(max < arr[idx]){
                max = arr[idx];
                answer = str.charAt(i);
            }
            else if(max == arr[idx]) answer = '?';
        }
        bw.write(answer);

        bw.flush();
        bw.close();
    }


}