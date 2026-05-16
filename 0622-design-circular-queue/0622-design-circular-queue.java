class MyCircularQueue {
     int front,rear,cnt;
     int[]q;
     int size;
    public MyCircularQueue(int k) {
        front=0;
        rear=0;
        cnt=0;
        size=k;
        q=new int[k];
    }
    
    public boolean enQueue(int value) {
        if(this.isFull())return false;
        q[rear]=value;
        rear=(rear+1)%size;
        cnt++;      
        return true;
    }
    
    public boolean deQueue() {
        if(this.isEmpty())return false;
        front=(front+1)%size;
        cnt--;
        return true;
    }
    
    public int Front() {
        if(this.isEmpty())return -1;
        return q[front];
    }
    
    public int Rear() {
        if(this.isEmpty())return -1;
        return q[(rear-1+size)%size];
    }
    
    public boolean isEmpty() {
        
       return cnt==0;
    }
    
    public boolean isFull() {
        
       return cnt==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */