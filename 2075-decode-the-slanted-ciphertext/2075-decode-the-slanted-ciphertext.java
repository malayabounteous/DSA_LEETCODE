class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        int len=encodedText.length();
        int col=(len+rows-1)/rows;
        System.out.println(col);
        char[][]mat=new char[rows][col];
        int c=0;

        for(int i=0;i<rows;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(c<len)
                {
                    mat[i][j]=encodedText.charAt(c);
                    c++;
                }
                else
                {
                   mat[i][j]='#';
                }
            }
        }
       

        StringBuilder sb=new StringBuilder();

        int i=0,j=0;
        while(i<rows && j<col)
        {
            int ti=0,tj=j;
            while(ti<rows && tj<col){
            sb.append(mat[ti][tj]);
            ti++;tj++;
            }
            i=0;
            j++;
            
        }
        return sb.toString().stripTrailing();
    }
}