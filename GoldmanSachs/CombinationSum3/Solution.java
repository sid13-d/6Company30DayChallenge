package GoldmanSachs.CombinationSum3;

import java.util.*;
class Solution {

   

    public void tryCombination(int start, int k, int n, List<Integer> temp, List<List<Integer>> ans){
        if(n<0){
            return;
        }
        if(k == temp.size()) {
            if(n == 0){
                ans.add(new ArrayList<>(temp));
                
            }
            return;
        }

        for(int i=start; i<=9; i++) {
            temp.add(i);
            tryCombination(i+1, k, n-i, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> ans = new ArrayList<>();
       
        tryCombination(1, k, n, new ArrayList<>(), ans);

        return ans;
    }
}
