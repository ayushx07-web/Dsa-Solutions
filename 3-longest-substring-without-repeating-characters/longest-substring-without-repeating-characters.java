class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        int left = 0;
        Set<Character> charSet = new HashSet<>();
        for(int right=0;right<s.length();right++){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left++));
            }
            charSet.add(s.charAt(right));
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}