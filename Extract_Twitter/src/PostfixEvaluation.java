import java.io.*;
class Stack
{
   private int[] a;
   private int top,m;
   public Stack(int max)
   {
     m=max;
     a=new int[m];
     top=-1;
   }
   public void push(int key)
   {
     a[++top]=key;
   }
   public int pop()
   {
     return(a[top--]);
   }
}

class PostfixEvaluation
{
   public static void main(String[] args)throws IOException
   {
     String input;
     while(true)
     {
       System.out.println("Enter the postfix expresion");
       input=getString();
       if(input.equals(""))
         break;
       Evaluation e=new Evaluation();
       System.out.println("Result:- "+e.calculate(input));
     }
   }
   public static String getString()throws IOException
   {
     DataInputStream inp=new DataInputStream(System.in);
     String s=inp.readLine();
     return s;
   }
}