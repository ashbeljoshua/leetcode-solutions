class Solution {
    public int findKthLargest(int[] nums, int k) {
    if(nums ==null) return 0;

    PriorityQueue<Integer> pqueue = new PriorityQueue<>((a,b)->a-b);
    for(int num : nums){
        pqueue.add(num);
        if(pqueue.size()>k) pqueue.poll();

    }
    return pqueue.peek();
        
    }
}