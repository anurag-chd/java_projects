
public class BinearySearch {
	public static void main(String args[]){
		int arr[] = {1,2,4,6,7,9,15};
		BSearch b = new BSearch();
		boolean result= b.search(arr, 0, (arr.length-1),8);
		System.out.println("The search result is:"+result);
		
		
	}
	

}

class BSearch{
	
	 boolean search(int [] arr,int min, int max,int x ){
		 int mid =  (min +max) /2;
		  if (arr[mid] == x){
				 return true;
		  }
		if (min == max)
			 return false;
		
			 
		  else if(arr[mid] > x){
			return  search(arr,min,mid,x);
			  
		  }
		  else if(arr[mid] < x){
			 return search(arr,mid+1,max,x);
		  }
		  return false;
		  
		 /*else if(arr[mid] != x)
			 return false;*/
			
		 
		 /*else{
			 return(search(arr,min,mid,x) || search(arr,mid+1,max,x));
		 }*/
		 
	 }
	
}
