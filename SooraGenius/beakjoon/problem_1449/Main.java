import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int L;

	private static boolean map[] = new boolean[1001];
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = null;

		tokenizer = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		L = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(reader.readLine());
		for(int i = 0; i<N; i++) {
			int pos = Integer.parseInt(tokenizer.nextToken());
			map[pos] = true;
		}
		int result = 0;
		for(int i = 0; i<map.length; i++) {
			if(map[i]) {
				i += L - 1;
				result++;
			}
		}

		System.out.println(result);
	}
}