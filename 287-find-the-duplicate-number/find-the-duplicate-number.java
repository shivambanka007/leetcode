class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length <2)return -1;
        // Duplicate number means there is a cycle in array.
        // Use fast and slow pointer
        int turtle= nums[0];
        int rabbit = nums[0];
        do {
            turtle = nums[turtle];
            rabbit = nums[nums[rabbit]];
        }while(turtle != rabbit );
        // Till here, the pointers have met, which means it is a cycle
        // Now reset the value of rabbit to 0 index and move both at same pace
        rabbit = nums[0];
        while(turtle != rabbit) {
            turtle = nums[turtle];
            rabbit = nums[rabbit];
        }
        return turtle;
    }
}