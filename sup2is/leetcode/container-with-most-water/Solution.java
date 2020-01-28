package container_with_most_water;

class Solution {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if(max > height[i] * (height.length - i)) {
                continue;
            }
            for (int j = i + 1; j < height.length; j++) {
                if(height[i] > height[j]) {
                    max = Math.max(max, (j - i) * height[j]);
                }else {
                    max = Math.max(max, (j - i) * height[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(solution.maxArea(new int[]{1,2,4,3}));
    }
}
