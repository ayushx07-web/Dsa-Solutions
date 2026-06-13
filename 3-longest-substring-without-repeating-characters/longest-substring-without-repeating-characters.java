class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charset = new HashSet<>();
        int left = 0;
        int maxlen = 0;
        for(int right=0;right<s.length();right++){
           char curr = s.charAt(right);
           while(charset.contains(curr)){
             charset.remove(s.charAt(left));
             left++;
           }
           charset.add(curr);
           maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
        
    }
}