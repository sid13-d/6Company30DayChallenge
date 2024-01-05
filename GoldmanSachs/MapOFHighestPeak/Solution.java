package GoldmanSachs.MapOFHighestPeak;
import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        
        int matrix[][] = new int[n][m];
        for(int row[]: matrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<Pair> qu = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(isWater[i][j] == 1) {
                    matrix[i][j] = 0;
                    qu.add(new Pair(i,j));
                }
            }
        }

        while(!qu.isEmpty()) {
            Pair curr = qu.poll();
            int r = curr.first;
            int c = curr.second;

            int[] dr = {1,0,-1,0};
            int[] dc = {0,1,0,-1};

            for(int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m && matrix[nr][nc] > 1+matrix[r][c]) {
                    matrix[nr][nc] = 1+matrix[r][c];
                    qu.add(new Pair(nr, nc));
                }
            }
        }

        return matrix;
    }
}

class Pair{
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}