class BrowserHistory {
     
    Stack<String>forward;
    Stack<String>backward;
    public BrowserHistory(String homepage) {
        forward=new Stack<>();
        backward=new Stack<>();
        forward.push(homepage);
        backward.push(homepage);
    }
    
    public void visit(String url) {
        forward.clear();
        backward.push(url);
        forward.push(url);
    }
    
    public String back(int steps) {
        String ans="";
        while(steps!=0 && backward.size()>1)
        {
            ans=backward.peek();
            backward.pop();
            forward.push(ans);
            steps--;
        }
        if(!backward.isEmpty()){
        ans=backward.peek();
        }
        return ans;
    }
    
    public String forward(int steps) {
        String ans="";
        while(steps!=0 && forward.size()>1)
        {
            ans=forward.peek();
            forward.pop();
            backward.push(ans);
            steps--;
        }
        if(ans=="")
        ans=forward.peek();
       
        return ans;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */