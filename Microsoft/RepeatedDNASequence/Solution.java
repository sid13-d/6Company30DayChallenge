package Microsoft.RepeatedDNASequence;

import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n<10 || n>10000) {
            return new ArrayList<>();
        }
        Set<String> seen=new HashSet<>(), repeated = new HashSet<>();

        for(int i=0; i+9<s.length(); i++) {
            String val = s.substring(i, i+10);
            if(!seen.add(val))
                repeated.add(val);
        }

        return new ArrayList(repeated);
    }

}
