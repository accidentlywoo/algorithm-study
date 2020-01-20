import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int height;
    public static int width;
    public static int map[][] = null;

    public static int BLANK = 0;
    public static int WALL = 1;
    public static int VIRUS = 2;

    public static int max = 0;

    public static void main(String args[]) throws IOException {
        StringTokenizer tokenizer = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        tokenizer = new StringTokenizer(reader.readLine());

        height = Integer.parseInt(tokenizer.nextToken());
        width = Integer.parseInt(tokenizer.nextToken());

        map = new int[width][height];
        for(int i = 0; i<height; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j<width; j++) {
                map[j][i] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        for(int i = 0; i<height; i++) {
            for(int j = 0; j<width; j++) {
                makeWall(j,i,0);
            }
        }
        System.out.println(max);
    }
    public static void makeWall(int x,int y, int count) {
        if(y == height) return;

        if(map[x][y] != BLANK) return;

        map[x][y] = WALL;
        if(count == 2) {
            List<Map.Entry<Integer, Integer>> entries = propagateVirus();

            max = Integer.max(max, countBlank());

            for(Map.Entry<Integer,Integer> entry : entries) {
                int ox = entry.getKey();
                int oy = entry.getValue();

                map[ox][oy] = BLANK;
            }
        }else {
            for(int ny = 0; ny < height; ny++) {
                for(int nx = 0; nx < width; nx++) {
                    makeWall(nx, ny, count + 1);
                }
            }
        }
        map[x][y] = BLANK;
    }

    public static List<Map.Entry<Integer,Integer>> propagateVirus() {
        List<Map.Entry<Integer,Integer>> propagatedPos = new ArrayList<>();

        int propagationCount = 0;
        do {
            propagationCount = 0;

            for(int y = 0; y<height; y++) {
                for(int x = 0; x<width; x++) {
                    List<Map.Entry<Integer,Integer>> movePosition = new ArrayList<>();
                    if(map[x][y] == VIRUS) {
                        Map.Entry<Integer, Integer> up = new AbstractMap.SimpleEntry<Integer, Integer>(x, y - 1);
                        Map.Entry<Integer, Integer> down = new AbstractMap.SimpleEntry<Integer, Integer>(x, y + 1);
                        Map.Entry<Integer, Integer> left = new AbstractMap.SimpleEntry<Integer, Integer>(x - 1, y);
                        Map.Entry<Integer, Integer> right = new AbstractMap.SimpleEntry<Integer, Integer>(x + 1, y);

                        movePosition.add(up);
                        movePosition.add(down);
                        movePosition.add(left);
                        movePosition.add(right);
                    }

                    for(Map.Entry<Integer,Integer> entry : movePosition) {
                        int nx = entry.getKey();
                        int ny = entry.getValue();
                        if(nx >= width || ny >= height || nx < 0 || ny < 0) {
                            continue;
                        }
                        if(map[nx][ny] == BLANK) {
                            propagatedPos.add(entry);

                            map[nx][ny] = VIRUS;
                            propagationCount++;
                        }
                    }
                }
            }
        }while(propagationCount > 0);

        return propagatedPos;
    }
    public static int countBlank() {
        int count = 0;
        for(int y = 0; y<height; y++) {
            for (int x = 0; x < width; x++) {
                if(map[x][y] == BLANK) {
                    count++;
                }
            }
        }
        return count;
    }
}