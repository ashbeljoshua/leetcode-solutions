
class MinStack {
  
    Stack<Integer> elementStack;
    Stack<Integer> minStack;
 

    public MinStack() {

        elementStack = new Stack<>();
        minStack = new Stack<>();
  
        
    }
    
    public void push(int val) {

        elementStack.push(val);
        if(minStack.isEmpty() || val<= minStack.peek()) {
            minStack.push(val);
        }
       
        
    }
    
    public void pop() {
      
      if(elementStack.isEmpty()) return;

        int popped = elementStack.pop();
        if(!minStack.isEmpty() && popped == minStack.peek()){
            minStack.pop();
        }
        
    }
    
    public int top() {
        if(elementStack.isEmpty()) return -1;
        return elementStack.peek();
     
    }
    
    public int getMin() {
      if(minStack.isEmpty()) return -1;
      return minStack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */