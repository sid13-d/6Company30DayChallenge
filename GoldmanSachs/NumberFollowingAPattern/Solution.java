package GoldmanSachs.NumberFollowingAPattern;

class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        StringBuffer ans = new StringBuffer();
        
        int cnt = 2;
        int pos = 0;
        ans.append('1');
        
        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i) == 'I'){
                ans.append(cnt);
                cnt++;
                pos = ans.length()-1;
            }else {
                ans.insert(pos, cnt);
                cnt++;
            }
        }
        
        return ans.toString();
    }
}

