package Walmart.Problem2099;

import java.util.*;
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
    PriorityQueue<int[]>pq=new PriorityQueue<>((a, b) -> b[0]-a[0]);

    for(int i=0;i<nums.length;i++){
        
        pq.add(new int[]{nums[i],i});
    
    }

    int[]check=new int[k];
    
    int i=0;
    int n=k;
    while(n>0){
    int m[]=pq.poll();
    check[i++]=m[1];
    n--;
    }

    Arrays.sort(check);

    int []ans=new int[k];

    for(int j=0;j<k;j++){
        ans[j]=nums[check[j]];
    }

    return ans;

    }
}