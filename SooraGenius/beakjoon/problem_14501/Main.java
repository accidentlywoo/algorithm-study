import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   public static int maxValue[] = new int[17];
   public static int N;
   public static int T[] = new int[17];
   public static int P[] = new int[17];
   public static void main(String[] args) throws IOException {
      StringTokenizer tokenizer = null;

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(bufferedReader.readLine());
      for(int i = 1; i<=N; i++) {
         tokenizer = new StringTokenizer(bufferedReader.readLine());
         T[i] = Integer.parseInt(tokenizer.nextToken());
         P[i] = Integer.parseInt(tokenizer.nextToken());
      }

      for(int i = 1; i<=N; i++) {
         int nextDay = i + T[i];
         int nextPay = maxValue[i] + P[i];
         if(nextDay - 1 > N) continue;
         if(nextPay > maxValue[nextDay]) {
            for(int j = nextDay; j<=N + 1; j++) {
               maxValue[j] = Integer.max(maxValue[j], nextPay);
            }
         }
      }
      int max = 0;
      for(int i = 0; i<maxValue.length; i++) {
         max = Integer.max(max, maxValue[i]);
//            System.out.println(i+" "+maxValue[i]);
      }
      System.out.println(max);
   }
}