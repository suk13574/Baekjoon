import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] house = new int[n];
		for(int i = 0 ; i < n ; i++) {
			house[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(house);
		
		int left = 1; //집 최소거리
		int right = house[n-1] - house[0]; //집 최대 거리
		int answer = 0;
		int d = 0;
		
		while(left <= right) { //이분탐색
			int mid = (left + right)/2;
			int start = house[0];
			int count = 1;
			//집 사이 거리가 최소 mid가 되도록 공유기 설치
			for(int i = 0 ; i < house.length;i++) {
				d = house[i] - start;
				if(d >= mid) {
					count++; //공유기 설치
					start = house[i];
				}
			}
			//공유기 개수 c보다 낮으면 최소거리 줄여서 다시 탐색
			if(count < c) right = mid - 1;
			//공유개 개수 c 이상이면 일단 답 저장하고 최소거리 늘려서 탐색
			else {
				answer = mid;
				left = mid + 1;
			}
		}
		
		System.out.println(answer);
	}

}
