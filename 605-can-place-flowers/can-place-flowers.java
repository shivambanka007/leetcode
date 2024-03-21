class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Stire the flowers and keep on decreasing the count n. If the count n is not zero before it reached the last 
        // position then that means we are not successful.

        if (flowerbed == null || flowerbed.length == 0 || flowerbed.length < n) return false;
        //Cases when the first pot is empty and the next pot is also empty
        //Check the first pod first 
        if (flowerbed.length == 1 ) {
            return (flowerbed[0] != 1 && n <=1 ) || n == 0;
        }
        // Check if we can place a flower in the first pod 
        if (flowerbed[1] != 1 && flowerbed[0] != 1) {
            flowerbed[0]=1;
            n--;
        }

        for(int i=1;i<flowerbed.length -1;i++) {
            if(flowerbed[i-1] != 1 && flowerbed[i] == 0 && flowerbed[i+1] != 1) {
                n--;
                flowerbed[i]=1;
            }
        }

        //Check the last place also
        if (flowerbed[flowerbed.length -1] != 1 && flowerbed[flowerbed.length - 2] != 1) {
            n--;
            flowerbed[flowerbed.length-1] = 1;
        }
        return n <=0;
    }
}