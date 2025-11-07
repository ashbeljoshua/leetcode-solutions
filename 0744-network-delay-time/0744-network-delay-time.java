class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        if(times == null ||times.length ==0 ) return -1;

        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i<=n;i++){
            graph.add(new ArrayList<>());

        }
        for(int [] time : times){
            int pre = time[0];
            int node = time[1];
            int weight = time[2];
            graph.get(pre).add(new int[]{node,weight});
        }
            int [] dist = new int[n+1];
            for(int i =0; i<dist.length;i++){
                dist[i] = Integer.MAX_VALUE;
            }
            dist[k] = 0;

        PriorityQueue<int []> queue = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        queue.offer(new int[] {0,k});

        while(! queue.isEmpty() ){
            int[] curr = queue.poll();
            int currTime = curr[0];
            int currNode = curr[1];
            for(int[] nei : graph.get(currNode)){
                int totalTime = currTime + nei [1];
                int neiNode = nei[0];
                if(totalTime < dist[neiNode]){
                    dist[neiNode] = totalTime;
                    queue.offer(new int[] {totalTime,neiNode});
                }
            }
        }

        int ans = 0;
        for(int  i = 1; i<dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);

        }
        return ans;
    }
}