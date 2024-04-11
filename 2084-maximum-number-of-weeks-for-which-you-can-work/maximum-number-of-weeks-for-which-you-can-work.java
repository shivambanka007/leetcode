class Solution {
    public long numberOfWeeks(int[] milestones) {
        // Main logic is similar to the CPU Scheduler problem
        // Place the less-frequent jobs in gap of most-frequent job
        long maxFreqMilestone = -1;
        long sumOfMilestonesExceptMax = 0;
        for(int milestone:milestones){
            sumOfMilestonesExceptMax+=milestone;
            maxFreqMilestone=Math.max(milestone,maxFreqMilestone);
        } 
        System.out.println(sumOfMilestonesExceptMax);
        sumOfMilestonesExceptMax -=maxFreqMilestone;
        // In n freq job, n-1 gap exists. If the other jobs are less than gap, then that means all the targets cannot be achieved => Return what can be achieved.
        if(maxFreqMilestone-1 > sumOfMilestonesExceptMax)return sumOfMilestonesExceptMax*2 + 1;
        
        return sumOfMilestonesExceptMax + maxFreqMilestone;
    }
}