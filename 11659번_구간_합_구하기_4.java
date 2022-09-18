import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] number = new int[n];
		for(int i = 0 ; i < n ; i++) {
			int num = sc.nextInt();
			if (i == 0) number[i] = num;
			else number[i] = number[i - 1] + num;
		}
		
		for (int i = 0; i < m; i++) {
			int start = sc.nextInt() - 1;
			int end = sc.nextInt() - 1;
			if(start == 0) System.out.println(number[end]);
			else System.out.println(number[end] - number[start - 1]);
		}
	}

}
