import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());	
		
		PriorityQueue<Integer> Lowerpq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> Biggerpq = new PriorityQueue<>();
		
		int num, gap;
		int mid = Integer.parseInt(bf.readLine());
		bw.append(mid+"\n");
		for(int i = 0 ; i < n-1; i++) {
			num = Integer.parseInt(bf.readLine());
			
			if (num < mid)
				Lowerpq.add(num);
			else if (num > mid)
				Biggerpq.add(num);
			else {
				if(Biggerpq.size() < Lowerpq.size()) Biggerpq.add(num);
				else Lowerpq.add(num);
			}
			gap = Lowerpq.size() - Biggerpq.size();

			if (gap == 1 || gap >= 2) {
				Biggerpq.add(mid);
				mid = Lowerpq.poll();
			} else if (gap <= -2) {
				Lowerpq.add(mid);
				mid = Biggerpq.poll();
			}
				
			bw.append(mid + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}

}