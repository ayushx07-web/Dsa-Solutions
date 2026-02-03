class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        for(char c:sentence.toCharArray()){
            if(Character.isLetter(c)){
                set.add(Character.toLowerCase(c));
            }
        }
        return set.size()==26;
    }
}