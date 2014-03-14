package Basics;

public class Sqrt {
	public static void main(String args[]){
		double num = 32;
		//int ans = getSqrt(32,0 ,32);
		findSquareRoot(num);
		//System.out.println(ans);
	}
	
	/*public static int getSqrt(int num, int start, int end){
		double x = 1;
		double y = 1;
		while(Math.abs(x-y)<.000001){
			y = x;
			x = 0.5 *(x+(num/x));
		}
		//return x;
		if (start >= end){
			return -1;
		}
		int middle = (start + end)/2;
		if(middle*middle == num){
			return middle;
		}
		else{
			if(middle*middle < num){
				middle = getSqrt(num, middle+1, end);
			}
			else{
				middle = getSqrt(num, start, middle);
			}
		return middle;	
		}
		
	}
*/
	
	 public static void findSquareRoot(double number)
	    {
	  
	        boolean isPositiveNumber = true;
	        double g1;
	  
	        //if the number given is a 0
	        if(number==0)
	        {
	            System.out.println("Square root of "+number+" = "+0);
	        }
	  
	        //If the number given is a -ve number
	        else if(number<0)
	        {  
	            number=-number;
	            isPositiveNumber = false;
	        }
	          
	        //Proceeding to find out square root of the number
	        double squareRoot = number/2;
	        do
	        {
	            g1=squareRoot;
	            squareRoot = (g1 + (number/g1))/2;
	        }
	        while((g1-squareRoot)!=0);
	  
	        //Displays square root in the case of a positive number
	        if(isPositiveNumber)
	        {
	            System.out.println("Square roots of "+number+" are ");
	            System.out.println("+"+squareRoot);
	            System.out.println("-"+squareRoot);
	        }
	        //Displays square root in the case of a -ve number
	        else
	        {
	            System.out.println("Square roots of -"+number+" are ");
	            System.out.println("+"+squareRoot+" i");
	            System.out.println("-"+squareRoot+" i");
	        }
	  
	    }
	}








//}
