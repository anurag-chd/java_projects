package Commvault;

public class IntToBinary {
	public static void main(String args[]){
		int num = 17;
		StringBuilder s = convertIntToBinary(num);
		System.out.println(s);
	}
	
	public static StringBuilder convertIntToBinary(int num){
		StringBuilder s = new StringBuilder();
		if(num == 0){
			s.append(0);
		}
		else{
			while(num>0){
				s.append(num%2);
				num = num/2;
			}
			
		}
		return s;
	}
	
}
