package LetterCombinationOfPhoneNO;

import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty())  return Collections.emptyList();
        String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


        List<String> output = new ArrayList<>();
    
            help("", digits, phone_map, output);

        return output;
    }

    void help(String combination, String next_digits, String[] phone_map, List<String> output) {

        if(next_digits.isEmpty()) {
            output.add(combination);
        
        }else {
            String letters = phone_map[next_digits.charAt(0) - '2'];
            for(char letter: letters.toCharArray()) {
                help(combination+letter, next_digits.substring(1), phone_map, output);
            }
        }

    }
}