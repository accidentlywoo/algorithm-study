package gas_station;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i<gas.length; i++) {
            // System.out.println("=========");
            if(loop(gas,cost,i)) {
                // System.out.println("!!+"+ i);
                return i;
            }
        }
        return -1;
    }
    public boolean loop(int []gas, int[] cost, int pos) {
        int nowGas = 0;
        for(int i = 0; i<gas.length; i++) {
            int nextStation = pos + i;
            if(nextStation >= gas.length) {
                nextStation -= gas.length;
            }
            // System.out.println(nextStation);
            nowGas += gas[nextStation];

            if(nowGas - cost[nextStation] < 0) return false;
            nowGas -= cost[nextStation];
        }
        if(nowGas >= 0) return true;
        return false;
    }
}