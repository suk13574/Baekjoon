import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.dgc.VMID;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lans = new int[k];
        long min = 0;
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(bf.readLine());
            max = Math.max(max, lans[i]);
        }

        long mid= 0;
        max++;
        while (min < max) {
            mid = (max + min) / 2;

            int piece = 0;
            for (int lan : lans) {
                piece += lan / mid;
            }

            if (piece < n) {
                max = mid;

            } else {
                min = mid + 1;
            }
        }
        
        System.out.println(min - 1);


    }
}