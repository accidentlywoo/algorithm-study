package beakjoon_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<int[]> queue = new LinkedList<>();
    static int[][] map;
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int canBreak;
    static int cnt;
    static boolean[][][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][2];
        String s;
        for (int i = 1; i <= n; i++) {
            s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j + 1] = s.charAt(j) - 48;
            }
        }

        queue.add(new int[]{1, 1, 0, 1}); // y, x, cnt, wall

        bfs();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            cnt = temp[2] + 1;
            canBreak = temp[3];

            if (temp[0] == map.length - 1 && temp[1] == map[0].length - 1) {
                System.out.println(cnt);
                return;
            }

            for (int i = 0; i < dir.length; i++) {

                int y = dir[i][0] + temp[0];
                int x = dir[i][1] + temp[1];

                if(y <= 0 || y > map.length - 1 || x <= 0 || x > map[0].length - 1) {
                    continue;
                }

                if (map[y][x] == 0 && !visited[y][x][canBreak]) {
                    queue.add(new int[]{y, x, cnt, canBreak});
                    visited[y][x][canBreak] = true;
                }

                if (map[y][x] == 1 && canBreak == 1 && !visited[y][x][canBreak]) {
                    queue.add(new int[]{y, x, cnt, canBreak - 1});
                    visited[y][x][canBreak] = true;
                }
            }
        }
        System.out.println(-1);
    }
}