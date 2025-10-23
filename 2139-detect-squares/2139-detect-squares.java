class DetectSquares {

    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();


    public DetectSquares() {
        
    }
    
    public void add(int[] point) {

        int x = point[0], y = point[1];
        map.computeIfAbsent(y,k-> new HashMap<>()).merge(x,1,Integer::sum);
      
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];

        if(!map.containsKey(y) ) return 0;

        Map<Integer, Integer> ymap = map.get(y);
        int total = 0;
        for(Map.Entry<Integer,Integer> inMap : ymap.entrySet()){

                int xkey = inMap.getKey();
                int counter = inMap.getValue();
                if(xkey==x ) continue;

                int d = Math.abs(xkey-x);

                total += counter *
                        getCount(x,y+d) * getCount(xkey,y+d);
                total += counter *
                        getCount(x,y-d) * getCount(xkey, y-d);



        }
        return total;

        }

         int getCount(int x, int y ) {
            Map<Integer, Integer> checkMap = map.get(y);
            return checkMap==null ? 0 : checkMap.getOrDefault(x,0);








        }      
        
    }


/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */