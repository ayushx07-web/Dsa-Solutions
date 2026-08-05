class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],1);
        }

        int min = nums[0];
        int max = nums[0];
        for(int num : nums){
            min = Math.min(num,min);
            max = Math.max(num,max);
        }
        for(int i=min;i<=max;i++){
            if(!map.containsKey(i)){
               list.add(i);
            } 

        }
        return list;
    }
}