package leetcode.container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        int maxAreaOfWater = 0;

        for(int i = 0; i < height.length; i++) {
            for(int j = i+1; j < height.length; j++) {
                int x = height[i] < height[j] ? height[i] : height[j];
                int areaOfWater = (j-i) * x;
                if(maxAreaOfWater < areaOfWater) {
                    maxAreaOfWater = areaOfWater;
                }
            }
        }

        return maxAreaOfWater;

    }
}
