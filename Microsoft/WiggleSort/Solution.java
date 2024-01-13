package Microsoft.WiggleSort;

import java.util.Arrays;
class Solution {
    public void wiggleSort(int[] nums) {
            int arr[] = nums.clone();
            Arrays.sort(arr);
            int n = nums.length;
            int i = (n-1) >> 1, j=n-1;
            for(int x=0; x<n; x++) {
                if(x%2 == 0) {
                    nums[x] = arr[i--];
                }else {
                    nums[x] = arr[j--];
                }
            }
    }
}
