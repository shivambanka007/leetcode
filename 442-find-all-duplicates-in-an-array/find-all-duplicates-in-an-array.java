class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int idx = 0;
        List<Integer> result = new ArrayList<>();
        while(idx < nums.length) {
            int currIdx = Math.abs(nums[idx]) -1;
            if (nums[currIdx] < 0) {
                //Means we encountered/visited this already
                result.add(currIdx + 1);
            } else {
                //Mark the node as visited
                nums[currIdx] = -1*Math.abs(nums[currIdx]);
            }
            idx++;
        }
        return result;
    }
}