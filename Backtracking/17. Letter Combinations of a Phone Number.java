/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

*/


class Solution {
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return  res;
        }
        Map<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "qprs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");

        backtrack(0, digits, "", res, digitToChar);
        return res;
    }

    private void backtrack(int i, String digits, String curStr, List<String> res, Map<Character, String> digitToChar) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        for (char c : digitToChar.get(digits.charAt(i)).toCharArray()) {
            backtrack(i + 1, digits, curStr + c, res, digitToChar);
        }
    }
}
