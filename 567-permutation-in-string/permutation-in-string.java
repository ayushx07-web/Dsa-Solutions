class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int[] freq1 = new int[26];
        int left = 0;
        for(int i=0;i<s1.length();i++){
            freq1[s1.charAt(i)-'a']++;
        }

        for(int right=0;right<s2.length();right++){
            freq[s2.charAt(right)-'a']++;

            if(right-left+1>s1.length()){
                freq[s2.charAt(left)-'a']--;
                left++;
            }

            if(right-left+1==s1.length()){
                if(Arrays.equals(freq,freq1))
                return true;
            }

        }
        return false;
    }
}