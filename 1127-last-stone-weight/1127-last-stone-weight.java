class Solution {
    public int lastStoneWeight(int[] stones) {

    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    for(int  i = 0; i<stones.length; i++){
        queue.offer(stones[i]);
    }

    while(queue.size()>1){
            int firstBig = queue.poll();
            int secondBig = queue.poll();
            if(firstBig != secondBig){
                queue.offer(firstBig-secondBig);
            }

    }
    return queue.size()==0 ?0 : queue.peek();
        
    }
}