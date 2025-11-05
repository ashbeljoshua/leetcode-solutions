class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }
        int[] preqArray = new int [numCourses];
        
        int coursesTaken = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int[] element : prerequisites){
            int pre = element[1];
            int course = element[0];
            graph.get(pre).add(course);
            preqArray[course]++;
        }
        for(int i = 0; i<preqArray.length;i++){
            if(preqArray[i]==0){
                queue.offer(i);
            }    
            
        }

        while(! queue.isEmpty()){

            int currCourse = queue.poll();
            coursesTaken++;

            for(int num : graph.get(currCourse)){
                preqArray[num]--;

                if(preqArray[num] == 0){
                    queue.offer(num);

                }
            }

        }

        return coursesTaken == numCourses;


        
    }
}