class Solution {   
    public int orangesRotting(int[][] grid) {                                  

     if(grid==null || grid.length==0 || grid[0].length==0) return 0;
     int m = grid.length;
     int n = grid[0].length;
     int[][] dirs ={{1,0},{-1,0},{0,1},{0,-1}};
     Queue<int[]> queue = new ArrayDeque<>();
     int countMin = 0;
     int freshOrange  = 0;
     for(int i=0;i<m;i++){
        for(int j = 0; j<n;j++){
            if(grid[i][j]==1) freshOrange++;
            if(grid[i][j]==2) queue.offer(new int[]{i,j});
        }
     }
     if(freshOrange==0) return 0;
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i=0;i<size;i++){
            int[] current = queue.poll();

            for(int[] dir: dirs){
                int row = current[0]+ dir[0];
                int column = current[1]+ dir[1];    
                if(row>=0 && row<m && column>=0 && column<n && grid[row][column]==1){
                    grid[row][column] = 2;
                    freshOrange--;
                    queue.offer(new int[]{row,column});
                }
            }
        }
        countMin++;
        if(freshOrange ==0) {
            return countMin;
        } 

    }

    return -1;


    }
}