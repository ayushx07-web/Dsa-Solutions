class Solution {

    public long maxSumTrionic(int[] nums) {

        int n = nums.length;

        long dp0 = Long.MIN_VALUE; // inc
        long dp1 = Long.MIN_VALUE; // inc -> dec
        long dp2 = Long.MIN_VALUE; // inc -> dec -> inc

        long ans = Long.MIN_VALUE;

        for (int i = 1; i < n; i++) {

            long newDp0 = Long.MIN_VALUE;
            long newDp1 = Long.MIN_VALUE;
            long newDp2 = Long.MIN_VALUE;

            // Start / extend increasing
            if (nums[i] > nums[i - 1]) {

                // extend inc
                if (dp0 != Long.MIN_VALUE)
                    newDp0 = dp0 + nums[i];

                // start new inc
                newDp0 = Math.max(newDp0, nums[i - 1] + nums[i]);

                // extend inc->dec->inc
                if (dp2 != Long.MIN_VALUE)
                    newDp2 = dp2 + nums[i];
            }

            // Start / extend decreasing
            if (nums[i] < nums[i - 1]) {

                // extend inc->dec
                if (dp1 != Long.MIN_VALUE)
                    newDp1 = dp1 + nums[i];

                // start inc->dec from inc
                if (dp0 != Long.MIN_VALUE)
                    newDp1 = Math.max(newDp1, dp0 + nums[i]);
            }

            // Start last inc from inc->dec
            if (nums[i] > nums[i - 1]) {

                if (dp1 != Long.MIN_VALUE)
                    newDp2 = Math.max(newDp2, dp1 + nums[i]);
            }

            dp0 = newDp0;
            dp1 = newDp1;
            dp2 = newDp2;

            ans = Math.max(ans, dp2);
        }

        return ans;
    }
}
