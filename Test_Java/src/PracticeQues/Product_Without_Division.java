package PracticeQues;

public class Product_Without_Division {
	public static void main(String args[]){
		int a[] = {1,2,3,4,5};
		String str1 = new String("anurag");
		String str2 = new String("anurag");
		if(str2 == str1){
			System.out.println("Same1 ");
		}
		if(str2.equals(str1)){
			System.out.println("Same1a ");
		}
		Product_Without_Division pwd = new Product_Without_Division();
		int result[] = pwd.get(a);
		System.out.print("{");
		for(int i : result){
			System.out.print(i+",");
		}
		System.out.print("}");
	}
	
	public int[] get(int []arr){
		int []p1 = new int[arr.length];
		int prod1 =1;
		for(int i = 0; i<arr.length;i++){
			p1[i]= prod1;
			prod1 = prod1 * arr[i];
			
		}
		int []p2 = new int[arr.length];
		int prod2 =1;
		
		for(int i = (arr.length-1) ; i>=0;i--){
			p2[i] = prod2;
			prod2 = prod2 * arr[i];
		}
		
		int result[] = new int [arr.length];
		for(int i = 0 ; i<arr.length ;i++){
			result[i] = p1[i] * p2[i];
		}
		return result;
	}
	
	
	
}
