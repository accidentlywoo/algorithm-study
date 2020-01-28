package beakjoon_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt;
    static int s;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0,0);
        
        if(s == 0) cnt --;

        System.out.println(cnt);
    }

   private static void dfs(int sum, int idx) {
      
      if(idx >= n) {
         if(sum == s) {
            cnt++;
         }
         return;
      }
      dfs(sum, idx + 1);
      dfs(sum + arr[idx], idx + 1);
   }
}