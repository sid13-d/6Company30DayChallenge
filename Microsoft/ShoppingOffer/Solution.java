package Microsoft.ShoppingOffer;

import java.util.*;
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs, 0);

    }

    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int sum=0;
        
        for(int i=0; i<price.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }//this will be my total sum required to buy items without offer

        //now we can apply each offer and check which is best
        int offerSize = special.size();
        for(int i=pos; i<offerSize; i++) {
            List<Integer> list = special.get(i);
            List<Integer> temp = new ArrayList<>();
            //checking if each offer can satisfy the needs
            for(int j=0; j<needs.size(); j++) {
                if(list.get(j) > needs.get(j)) {
                    temp = null;
                    break;
                }

                temp.add(needs.get(j)-list.get(j));
            }

            if(temp != null) {
                sum = Math.min(sum, list.get(list.size()-1) + helper(price, special, temp, i));
            }
        }

        return sum;
    }
}
