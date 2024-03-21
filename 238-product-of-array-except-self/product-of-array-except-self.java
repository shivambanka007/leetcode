class Solution {
    public int[] productExceptSelf(int[] nums) {
        //[1,1,2,6] [24,12,4,1]
        int preProd=1;
        int[] prefixProduct = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            prefixProduct[i] = preProd;
            preProd = preProd*nums[i];
        }
        int[] suffixProduct = new int[nums.length];
        int suffProd=1;
        for(int i=nums.length-1;i>=0;i--) {
            suffixProduct[i] = suffProd * prefixProduct[i];
            suffProd = suffProd*nums[i];
        }

       return suffixProduct;
    }
}