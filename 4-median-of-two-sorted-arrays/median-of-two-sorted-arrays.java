class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Solution using Priority Queue implementation
	Queue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
	for(int i:nums1)pq.add(i);
	for(int i:nums2)pq.add(i);
	int n=nums1.length + nums2.length;
	if(n%2==1){
		int med=0;
		for(int count=0;count<=n/2;count++){med=pq.poll();}
		return med;
	}
	else{
		int med1=0,med2=0;
		for(int count=0;count<=n/2;count++){
			med2=med1;
			med1=pq.poll();
		}
		return (double)(med1+med2)/2;
	}
    }
}