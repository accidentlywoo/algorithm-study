package beakjoon_1758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        long sum = 0;
        int rank = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (o1, o2) -> Integer.compare(o2, o1));
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int tip = arr[i] - (rank - 1);
            if(tip > 0) {
                sum += tip;
            }
            rank ++;
        }

        System.out.println(sum);

    }
}