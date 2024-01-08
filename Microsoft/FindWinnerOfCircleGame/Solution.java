package Microsoft.FindWinnerOfCircleGame;

import java.util.*;
class Solution {
    int alive;
    public int findTheWinner(int n, int k) {
        int index=0;
        k--;
        List<Integer> person = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            person.add(i);
        }
        personAlive(index, person, k);
        return alive;
    }

    public void personAlive(int i, List<Integer> arr,int k) {

        if(arr.size() == 1) {
            alive = arr.get(0);
            return;
        }
        i = ((i+k))%arr.size();
        arr.remove(i);
        personAlive(i, arr, k);
    }
}
