class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int result=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int head=0; int tail = 0;
        while(tail <nums.length) {
            map.put(nums[tail],map.getOrDefault(nums[tail],0)+1);
            // If the frequency of any element crosses k, then move start pointer to the right
            while(map.get(nums[tail])>k) {
                map.put(nums[head],map.get(nums[head])-1);
                head++;
            }
            result = Math.max(result,(tail-head+1));
            tail++;
        }
        return result;
    }
}