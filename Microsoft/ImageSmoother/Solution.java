package Microsoft.ImageSmoother;

import java.util.*;
class Solution {
    public int[][] imageSmoother(int[][] img) {
       var moves = new int[] {-1, 0, 1};

    var m = img.length;
    var n = img[0].length;

    var res = new int[m][n];

    for (var i=0; i<m; i++) {
      for (var j=0; j<n; j++) {
        var cnt = 0;
        var val = 0;

        for (var a : moves) {
          for (var b : moves) {
            var x = i + a;
            var y = j + b;

            if (x < 0 || x >= m || y < 0 || y >= n) continue;

            cnt++;
            val += img[x][y];
          }
        }
        res[i][j] = val / cnt;
      }
    }
    return res;
    }
}
