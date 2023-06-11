import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int n;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        for(int i = 1; i < n + 1; i++){
            st = new StringTokenizer(bf.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][k + 1];

        for(int j = 1; j < k + 1; j++){
            for(int i = 1; i < n + 1; i++){

                // 넣으려는 물건의 무게(w[i])가 지정한 최대 무게(j)보다 무거운 경우
                if(w[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                // 현재 물건 가방에 넣을 수 있을 경우 최대 가중치 계산
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }   
        }

        System.out.println(dp[n][k]);
    }
    
}