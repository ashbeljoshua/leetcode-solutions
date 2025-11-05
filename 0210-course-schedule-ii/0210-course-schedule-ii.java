class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {


         List<List<Integer>> graph = new ArrayList<>();
         int [] courseOrder = new int[numCourses];
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
        int i = 0;
        while(! queue.isEmpty()){
             
            int currCourse = queue.poll();
            courseOrder[i] = currCourse;

            coursesTaken++;

            for(int num : graph.get(currCourse)){
                preqArray[num]--;

                if(preqArray[num] == 0){
                    queue.offer(num);

                }
            }
            i++;

        }

        return coursesTaken == numCourses ?courseOrder : new int[0];


        
    }
}