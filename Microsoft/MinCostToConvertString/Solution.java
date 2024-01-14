package Microsoft.MinCostToConvertString;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int adj[][] = new int[26][26];

       for(int i=0; i<26; i++) {
           Arrays.fill(adj[i], Integer.MAX_VALUE);
            adj[i][i] = 0;
       }

       for(int i=0; i<cost.length; i++) {
           int a = original[i] - 'a';
           int b = changed[i] - 'a';
           adj[a][b] = Math.min(adj[a][b], cost[i]);
       }

       for(int k=0; k<26; k++) {
           for(int i=0; i<26; i++) {
               if(adj[i][k] < Integer.MAX_VALUE) {
                   for(int j=0; j<26; j++) {
                       if(adj[k][j] < Integer.MAX_VALUE) {
                           adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                       }
                   }
               }
           }
       }

       long ans = 0L;
       for(int i=0; i<source.length(); i++) {
           int c1 = source.charAt(i) - 'a';
           int c2 = target.charAt(i) - 'a';

           if(adj[c1][c2] == Integer.MAX_VALUE){
               return -1L;
           }else {
               ans += (long) adj[c1][c2];
           }
       }

       return ans;
    }
}
