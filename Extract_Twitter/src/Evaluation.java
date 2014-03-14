class Evaluation{
   public int calculate(String s)
   {
     int n,r=0;
     n=s.length();
     Stack a=new Stack(n);
     for(int i=0;i<n;i++)
     {
       char ch=s.charAt(i);
       if(ch>='0'&&ch<='9')
         a.push((int)(ch-'0'));
       else
       {
         int x=a.pop();
         int y=a.pop();
         switch(ch)
         {
           case '+':r=x+y;
              break;
           case '-':r=y-x;
              break;
           case '*':r=x*y;
              break;
           case '/':r=y/x;
              break;
           default:r=0;
         }
         a.push(r);
       }
     }
     r=a.pop();
     return(r);
   }
}