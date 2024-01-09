package Microsoft.MinimumMovesToEqualArray;

import java.util.*;
class Solution {
    public int minMoves2(int[] nums) {
        int start=0; 
        int end = nums.length-1;
        int cost=0;

        Arrays.sort(nums);
        while(start<end) {
            cost += nums[start]-nums[end];
            start++;
            end--;
        }

        return Math.abs(cost);
    }
}