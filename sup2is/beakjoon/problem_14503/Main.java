package beakjoon_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int cnt = 0;
	static int findCnt;
	static int r;
	static int c;
	static int d;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if(map[r][c] == 0) {
			clear();
		}

		while (true) {
			try {
				recursive();
			}catch (Exception e) {
				System.out.println(cnt);
				return ;
			}
		}
	}

	private static void clear() {
		map[r][c] = cnt + 2;
		cnt ++;
	}

	private static boolean canMove() {
		int tr = (r + dir[d][0]);
		int tc = (c + dir[d][1]);

		if(tr > 0 && tc > 0 && tr < map.length && tc < map[0].length && map[tr][tc] == 0) {
			findCnt = 0;
			return true;
		}

		return false;
	}

	private static void recursive() throws Exception {
		if (findCnt == 4) {
			backward();
		}

		d =  (d + 3) % 4;
		
		if(canMove()){
			r = r  + dir[d][0];
			c = c + dir[d][1];
			clear();
		}else {
			findCnt++;
			recursive();
		}

	}

	private static void backward() throws IllegalAccessException {
		int td = (d + 2) % 4;
		int tr = r + dir[td][0];
		int tc = c + dir[td][1];

		if(tr > 0 && tc > 0 && tr < map.length && tc < map[0].length && map[tr][tc] != 1) {
			findCnt = 0;
			r = r  + dir[td][0];
			c = c + dir[td][1];
		}else {
			throw new IllegalAccessException();
		}
	}
}
