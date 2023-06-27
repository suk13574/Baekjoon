import java.io.*;
import java.util.*;

import javax.swing.text.AbstractDocument.LeafElement;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //입력
        st = new StringTokenizer(bf.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] matrix = new int[w];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < w; i++){
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int left = matrix[0];

        for(int i = 1;i < w - 1; i++){
            int right = 0;

            left = Math.max(left, matrix[i]);

            for(int j = i + 1; j < w; j++){
                right = Math.max(right, matrix[j]);
            }

            if(matrix[i] < Math.min(left, right)){
                answer += Math.min(left, right) - matrix[i];
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

}