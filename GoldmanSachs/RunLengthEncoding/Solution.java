package GoldmanSachs.RunLengthEncoding;
// https://www.geeksforgeeks.org/problems/run-length-encoding/1

// import java.util.*;
public class Solution {
	String encode(String str)
	{
          //Your code here
          StringBuilder ans = new StringBuilder();
          
          int cnt=1;
          for(int i=1; i<str.length(); i++) {
            
                if(str.charAt(i) == str.charAt(i-1)) {
                    cnt++;
                }else{
                    ans.append(str.charAt(i-1));
                    ans.append(cnt);
                    cnt=1;
                }
          }
          
          ans.append(str.charAt(str.length()-1));
          ans.append(cnt);
          
          return ans.toString();
	}
	
 }
