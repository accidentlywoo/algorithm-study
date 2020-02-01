package gas_station;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
       
       Queue<Integer> station = new LinkedList<>();
       int min = Integer.MAX_VALUE;
       getVaildStation(gas,cost,station);
       
       loop : while (!station.isEmpty()) {
          int idx = station.poll();
          int currentGas = gas[idx];
          
          for (int i = 0; i < gas.length; i++) {
             currentGas -= cost[idx];
             
             if(currentGas < 0) continue loop;
             
             idx = (idx + 1) % gas.length;
             currentGas += gas[idx];
         }
          min = Math.min(min, idx);
      }
       return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private void getVaildStation(int[] gas, int[] cost, Queue<Integer> station) {
       for (int i = 0; i < cost.length; i++) {
         if(gas[i] >= cost[i]) {
            station.add(i);
         }
      }
   }
   public static void main(String[] args) {
       
       Solution solution = new Solution();
       System.out.println(solution.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
       System.out.println(solution.canCompleteCircuit(new int[] {5,1,2,3,4}, new int[] {4,4,1,5,1}));
       System.out.println(solution.canCompleteCircuit(new int[] {2}, new int[] {2}));
       
   }
}