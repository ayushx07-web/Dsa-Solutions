class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int begin = nums[i];

            while(i+1<nums.length && nums[i+1]==nums[i]+1){
                i++;
            }
            int end=nums[i];

            if(begin==end){
                result.add(String.valueOf(begin));
            } else{
                result.add(begin+"->"+end);
            }
            i++;
        }
        return result;
    }
}