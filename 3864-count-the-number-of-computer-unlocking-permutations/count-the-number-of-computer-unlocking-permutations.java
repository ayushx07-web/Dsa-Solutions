class Solution {
    public int countPermutations(int[] complexity) {
        final int MOD = 1_000_000_007;
        int n = complexity.length;
        // check that every computer i>0 has complexity > complexity[0]
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }
        long res = 1;
        for (int i = 1; i < n; i++) {
            res = (res * i) % MOD;
        }
        return (int) res;
    }
}
