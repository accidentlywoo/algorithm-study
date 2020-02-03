package beakjoon_1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;
        char before = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {

            if(before == '0' && s.charAt(i) == '1') {
                zeroCnt ++;
                before = s.charAt(i);
            }

            if(before == '1' && s.charAt(i) == '0') {
                oneCnt ++;
                before = s.charAt(i);
            }

        }

        if(s.charAt(s.length() - 1) == '0') {
            zeroCnt ++;
        }else {
            oneCnt ++;
        }

        System.out.println(zeroCnt > oneCnt ? oneCnt : zeroCnt);
    }
}