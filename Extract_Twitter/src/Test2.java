
public class Test2 {
	/*public int solve(int arr[]){
		int low = 0;
		int high = arr.length;
		int result;
		result = find(low,high,arr);
		return result;
	}
	
	
	public int find(int low, int high, int arr []){
		int sum1,sum2 = 0;
		int mid = (low + high)/2;
		System.out.println("Medium ="+mid);
		sum1 = sum(low,mid,arr);
		sum2 = sum(mid+1,high,arr);
		if (sum1 == sum2){
			return mid;
		}
		find(low,mid-1,arr);
		find(mid+1,high,arr);
		if(sum1 > sum2){
		     find(low,mid-1,arr);
		}
		else if(sum1 <sum2){
			 find(mid+1,high,arr);
		}
		 
			
		
			return -1;
		
		
	}
	
	public int sum(int low, int high, int arr []){
		int i = 0;
		int sum = 0;
		for(i = low;i < high; i++){
			sum = sum + arr[i];
		}
		return sum;
		
		
	}
	
	*/
	
	public int equi ( int[] A ) {
	    long sum = 0;
	    int i = 0;
	    
	    for (i = 0; i < A.length; i++) {
	        sum += (long) A[i];
	    }
	    
	    long sum_left = 0;
	    for (i = 0; i < A.length; i++) {
	        long sum_right = sum - sum_left - (long) A[i];
	        
	        if (sum_left == sum_right) {
	            return i;
	        }
	        sum_left += (long) A[i];
	    }
	    return -1;// write your code here
	  }
	public static void main(String args []){
		int result=0;
		Test2 t = new Test2();
		int arr[] = {7,1,4,1,2};
		result = t.equi(arr);
		System.out.println("result array"+result);
		
	}
	

}
