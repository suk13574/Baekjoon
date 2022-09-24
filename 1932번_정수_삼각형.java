import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Integer>[] triangle = new ArrayList[n];
		for(int i = 0; i < n ; i++) {
			String str = bf.readLine();
			String[] strArr = str.split(" ");
			triangle[i] = new ArrayList<>();
			for(String s : strArr) {
				triangle[i].add(Integer.parseInt(s));
			}
		}//정수 삼각형 저장
		
		int answer = triangle[0].get(0);
		
		
		for (int i = 1; i < n ; i++) {
			for (int j = 0; j < triangle[i].size(); j++) {
				if (j == 0) {
					triangle[i].set(j, triangle[i].get(j) + triangle[i - 1].get(0));
				} else if (j == triangle[i].size() - 1) {
					triangle[i].set(j, triangle[i].get(j) + triangle[i - 1].get(triangle[i - 1].size() - 1));
				}
				else {
					int a = triangle[i].get(j) + triangle[i - 1].get(j - 1);
					int b = triangle[i].get(j) + triangle[i - 1].get(j);
					triangle[i].set(j, Math.max(a, b));
				}
				
				answer = Math.max(answer, triangle[i].get(j));
			}
		}
		System.out.println(answer);
		
	}

}
