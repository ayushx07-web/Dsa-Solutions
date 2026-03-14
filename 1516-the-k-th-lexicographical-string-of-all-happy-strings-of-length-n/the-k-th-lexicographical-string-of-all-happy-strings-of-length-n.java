class Solution {
    List<String> res = new ArrayList<>();

    public String getHappyString(int n, int k) {
        backtrack(n, "");
        if (k > res.size()) return "";
        return res.get(k - 1);
    }

    private void backtrack(int n, String curr) {
        if (curr.length() == n) {
            res.add(curr);
            return;
        }

        for (char c : new char[]{'a','b','c'}) {
            if (curr.length() > 0 && curr.charAt(curr.length()-1) == c) {
                continue;
            }
            backtrack(n, curr + c);
        }
    }
}