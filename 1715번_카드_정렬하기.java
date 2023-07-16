import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> card = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            card.add(Long.parseLong(br.readLine()));
        }

        long answer = 0;
        while(card.size() > 1) {
            long temp = card.poll() + card.poll();
            card.add(temp);
            answer += temp;
        }
        System.out.println(answer);

    }

}