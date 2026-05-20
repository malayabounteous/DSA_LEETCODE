class ATM {
    int[]cashes;
    int[]value;
    public ATM() {
        cashes=new int[5];
        Arrays.fill(cashes,0);
        value=new int[]{20,50,100,200,500};
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;++i)
        cashes[i]+=banknotesCount[i];
    }
    
    public int[] withdraw(int amount) {
        if(amount%10!=0)return new int[]{-1};
        int[]ans=new int[5];
        int index=4;
        while(amount>0 && index>=0)
        {
           //int total= cashes[index]*value[index];
           int notes=amount/value[index];
           if(cashes[index]>=notes)
           {
             ans[index]=notes;
             amount-=notes*value[index];
           }
           else
           {
            ans[index]=cashes[index];
            amount-=cashes[index]*value[index];
           }
           index--;
        }
        if(amount!=0)
        return new int[]{-1};

        for(int i=0;i<5;++i)
        {
            cashes[i]-=ans[i];
        }
        return ans;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */