package beakjoon_1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        final String targetA = "XXXX";
        final String targetB = "XX";
        final String AAAA = "AAAA";
        final String BB = "BB";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        int idx = 0;

        while (idx < s.length()) {

            if(idx + AAAA.length() <= s.length()) {
                String substring = s.substring(idx, targetA.length() + idx);
                if(substring.equals(targetA)) {
                    sb.append(AAAA);
                    idx += AAAA.length();
                    continue;
                }
            }

            if(idx + BB.length() <= s.length()) {
                String substring = s.substring(idx, targetB.length() + idx);
                if(substring.equals(targetB)) {
                    sb.append(BB);
                    idx += BB.length();
                    continue;
                }
            }

            if(s.charAt(idx) == '.') {
                sb.append(".");
                idx ++;
                continue;
            }

            System.out.println(-1);
            return;

        }

        System.out.println(sb.toString());
    }
}