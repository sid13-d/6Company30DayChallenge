package Microsoft.RussianDollEnvelopes;

import java.util.*;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n == 0) {
            return 0;

        }

        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }else {
                return a[0] - b[0];
            }
        });

        int nums[] = new int [envelopes.length];
        int j =0;
        for(int i=0; i<envelopes.length; i++) {
            nums[j] = envelopes[i][1];
            j++;
        }

        return lengthOfLIS(nums);

    }

    public int lengthOfLIS(int nums[]) {
        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int index = binary(al,nums[i]);
            if(index == al.size()) {
                al.add(nums[i]);
            }else {
                al.set(index, nums[i]);
            }
        }

        return al.size();
    }

    public int binary(ArrayList<Integer> al,int target) {
        int s =0;
        int e=al.size();
        int result=al.size();
        while(s<e) {
            int mid = (s+e)/2;
            if(al.get(mid)<target) {
                s=mid+1;
            }else {
                e=mid;
                result=mid;
            }
        }

        return result;
    }
}
