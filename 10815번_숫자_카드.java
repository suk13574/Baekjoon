import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[] cards = new int[n];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);

		int m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());

		int num;
		for (int i = 0; i < m; i++) {
			num = Integer.parseInt(st.nextToken());
			if(binarySearch(cards, num)) bw.write(1 + " ");
			else bw.write(0 + " ");
		}
		bw.flush();
		bw.close();
	}

	public static boolean binarySearch(int[] cards, int num) {
		int start = 0;
		int end = cards.length - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if(cards[mid] > num) end = mid - 1;
			else if(cards[mid] < num) start = mid + 1;
			else return true;
		}
		return false;
	}

}
