import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < n ; i++){
            String answer = null;

            String str = bf.readLine();
            int k = Integer.parseInt(bf.readLine());
            answer = checkStr(str, k);
            if(answer == null) bw.write(-1 + "\n");
            else bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    static String checkStr(String str, int k){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //문자의 알파벳별 개수 저장
        int[] alphabet = new int[26];
        for(int i = 0; i < str.length(); i++){
            alphabet[str.charAt(i) - 'a']++;
        }


        for(int i = 0 ; i < str.length(); i++){
            //문자열의 i번째 알파벳이 k개 이하이면 패스
            if(alphabet[str.charAt(i) - 'a'] < k) continue;

            //문자열의 i번째 알바벳으로 시작하는 단어 찾기
            int count = 0;
            for(int j = i; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)) count++;
                if(count == k) {
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
            return null;
        }

        return min + " " + max;
    }
}