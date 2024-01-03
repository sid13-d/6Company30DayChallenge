package GoldmanSachs.RandomFlipMatrix;

// https://leetcode.com/problems/random-flip-matrix/submissions/

import java.util.*;
class Solution {

    public int matrix[][];
    HashMap<Integer, Integer> map;
    Random rand;
    int zeros;
    int n,m;
    public Solution(int m, int n) {
        map = new HashMap<>();
        rand = new Random();
        zeros = m*n;
        this.n = n;
        this.m = m;
    }

    
    public int[] flip() {
        int pos = rand.nextInt(zeros);
        int actual = map.getOrDefault(pos, pos);
        int ret[] = new int[]{actual/n, actual%n};
        
        map.put(pos, map.getOrDefault(zeros-1, zeros-1));
        zeros--;
        
        return ret;
    }
    
    public void reset() {

       map.clear();
       zeros=m*n;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
