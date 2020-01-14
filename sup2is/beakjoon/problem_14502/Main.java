package beakjoon_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int max;
    static Queue<int[]> viruses = new LinkedList<>();
    static int n;
    static int m;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        int mul = n * m;

        for (int i = 0; i < mul - 2; i++) {
            if (map[i / m][i % m] == 1 || map[i / m][i % m] == 2) continue;
            map[i / m][i % m] = 1;

            for (int j = 0; j < mul - 1; j++) {
                if (map[j / m][j % m] == 1 || map[j / m][j % m] == 2) continue;
                map[j / m][j % m] = 1;

                for (int k = 0; k < mul; k++) {
                    if (map[k / m][k % m] == 1 || map[k / m][k % m] == 2) continue;
                    map[k / m][k % m] = 1;

                    infection();
                    find();
                    clear();
                    reset();

                    map[k / m][k % m] = 0;
                }
                map[j / m][j % m] = 0;
            }
            map[i / m][i % m] = 0;
        }
        System.out.println(max);
    }

    private static void reset() {
        for (int[] virus : viruses) {
            map[virus[0]][virus[1]] = 2;
        }
    }

    private static void clear() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void find() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }

    private static void infection() {
        Queue<int[]> copyOfViruses = new LinkedList<>(viruses);

        while (!copyOfViruses.isEmpty()) {

            int[] temp = copyOfViruses.poll();

            int y = temp[0];
            int x = temp[1];

            if (x - 1 >= 0 && map[y][x - 1] == 0) {
                copyOfViruses.add(new int[]{y, x - 1});
                map[y][x - 1] = 2;
            }
            if (y - 1 >= 0 && map[y - 1][x] == 0) {
                copyOfViruses.add(new int[]{y - 1, x});
                map[y - 1][x] = 2;
            }
            if (y + 1 < n && map[y + 1][x] == 0) {
                copyOfViruses.add(new int[]{y + 1, x});
                map[y + 1][x] = 2;
            }
            if (x + 1 < m && map[y][x + 1] == 0) {
                copyOfViruses.add(new int[]{y, x + 1});
                map[y][x + 1] = 2;
            }
        }

    }


    public static void print() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("===");
    }
    
}