class DetectSquares {

    Map<Integer, Map<Integer,Integer>> entries = new HashMap<>();

    public DetectSquares() {
        
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        entries.computeIfAbsent(y, k-> new HashMap<>()).merge(x,1,Integer::sum);
      
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];
        Map<Integer, Integer> xvalues = entries.get(y);
        if(xvalues == null) return 0;
        int total = 0;

        for(Map.Entry<Integer,Integer> xval : xvalues.entrySet()){
            int xkey = xval.getKey();
            int counter = xval.getValue();
            if(xkey == x) continue;
        
            int d = Math.abs(xkey-x);

            total += counter * getCount(x,y+d) * getCount(xkey,y+d);
            total += counter * getCount(x,y-d) * getCount(xkey,y-d);


        }

        return total;


        }
        int getCount(int x, int y){
            Map<Integer,Integer> checkMap = entries.get(y);
            return checkMap==null ? 0 : checkMap.getOrDefault(x,0);

        }

               
        
    }


/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */