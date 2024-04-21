class Solution {
    public int minimizeArrayValue(int[] nums) {
        // Firstly find the max of array
        int max = nums[0];
        for(int num:nums)max = Math.max(max,num);

        // Now we loop from 1 to the max Number using binary search , for which number fits the problem
        int low = 0 ;
        int high = max;
        int result= 0;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(isPossible(mid,nums)){
                result = mid;
                //shrink the window
                high = mid-1;
            } else {
                //expand the window
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean isPossible(int max,int[] nums) {
        // We have to check if it is possible to acheive the max value, given we perform multiple such operations mentioned in the question. 
        //Why nums.length - 1 ?  
        long bufferMoves=0;
        for(int n:nums) {
            // If the number is smaller than proposed max number, nothing needed
            // Just calculate the buffer moves available for i+1 index
            if(n <= max)bufferMoves += max-n;
            else {
                // If the number exceeds proposed max value,we can move some values to the i-1 index, based on available buffer
                if(bufferMoves < n-max)return false; // Buffer moves are less, so the current max not attainable
                else bufferMoves -= n - max; // Perform required operations
            }
        }
        return true;
    }
}