package beakjoon.problem_1439;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < line.length(); i++) {
            for(int j = i+1; j <= i; j++) {
                if(line.charAt(i) == '1') {
                    if(line.charAt(i) != line.charAt(j)) {
                        count1++;
                    }
                }else if(line.charAt(i) == '0') {
                    if(line.charAt(i) != line.charAt(j)) {
                        count2++;
                    }
                }
            }
        }
        
        System.out.println(count1 > count2 ? count2 : count1);
    }
}