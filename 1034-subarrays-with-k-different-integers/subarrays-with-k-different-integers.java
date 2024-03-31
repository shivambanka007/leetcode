class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Exactly k = atmost(k) - atmost(k-1)
        int atmostK = solveAtmostK(nums,k);
        int atmostKMinusOne = solveAtmostK(nums,k-1);
        return atmostK - atmostKMinusOne; 
    }

    private int solveAtmostK(int[] nums , int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0,right=0,result =0;
        while(right < nums.length) {
            // Include the current element in map 
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            // If the number of distinct elements exceed k , move left ptr to right
            while(map.size() > k) {
                //Decrease freq of left as we are moving left ptr to right
                map.put(nums[left],map.get(nums[left]) - 1);
                // If the element freq is zero , then remove from map
                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                // Move the left pointer to right;
                left++;
            }
            // Number of subarrays between these elements = size of window
            result += right-left + 1;
            //Move the right pointer to right;
            right++;
        }
        return result;
    }
}