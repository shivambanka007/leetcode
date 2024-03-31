class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        // Take note of the index of minK,maxK and the last occurence of bad k
        int minKIndex = -1;
        int maxKIndex = -1;
        long result = 0;
        int badKIndex = -1;

        for(int i=0;i<nums.length;i++) {
            //Record badK indx 
            if(nums[i]>maxK || nums[i]<minK)badKIndex=i;
            //Record minK Index 
            if(nums[i] == minK)minKIndex=i;
            if(nums[i]==maxK)maxKIndex=i;

            //Number of valid sub-arrays = min(leftIndex,rightIndex) - badIndex 
            // I.e arrays between the leftmost permissible value and badIndex,excluding the badIndex
            result+=Math.max(0,Math.min(minKIndex,maxKIndex)-badKIndex);
        }
        return result;
    }
}