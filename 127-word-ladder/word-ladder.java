class Pair{
    String word;
    int steps;
    Pair(String word,int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String i : wordList){
            set.add(i);
        }

        queue.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!queue.isEmpty()){
            String w = queue.peek().word;
            int s = queue.peek().steps;
            queue.remove();

            if(w.equals(endWord))
                return s;

            for(int i=0;i<w.length();i++){
                char[] arr = w.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    arr[i] = ch;
                    String newWord = new String(arr);

                    if(set.contains(newWord)){
                        set.remove(newWord);
                        queue.add(new Pair(newWord,s+1));
                    }
                }
            }
        }
        return 0;
    }
}