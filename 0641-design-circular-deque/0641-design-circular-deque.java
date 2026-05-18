class MyCircularDeque {
    
    int size;
    int[]q;
    int cnt=0;
    int front=-1;
    int rear=-1;
    public MyCircularDeque(int k) {
        size=k;
        this.q=new int[k];
    }
    
    public boolean insertFront(int value) {
        if(cnt==size)return false;
        if(cnt==0)
        {
            front=0;rear=0;
        }
        else
        front=(front-1+size)%size;
        q[front]=value;
        cnt++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(cnt==size)return false;
        if(cnt==0)
        {
            front=0;rear=0;
        }
        else
        rear=(rear+1)%size;
        q[rear]=value;
        cnt++;
        return true;
    }
    
    public boolean deleteFront() {
        if(cnt==0)return false;
      
        front=(front+1)%size;
        cnt--;
        return true;
    }
    
    public boolean deleteLast() {
        if(cnt==0)return false;
        rear=(rear-1+size)%size;
        cnt--;
        return true;
    }
    
    public int getFront() {
        if(cnt==0)return -1;
        return q[front];
    }
    
    public int getRear() {
        if(cnt==0)return-1;
        return q[rear];
    }
    
    public boolean isEmpty() {
        return cnt==0;
    }
    
    public boolean isFull() {
        return cnt==size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */