package CTCI;

public class RemDuplicates {
	public static void main(String args[]){
		String str = "anuragaruna";
		RemDuplicates rd = new RemDuplicates();
		rd.go(str);
		
	}

	public void go(String str){
		if(str == null){
			return ;
		}
		if(str.length() < 2){
			return;
		}
		else{
			char [] c = str.toCharArray();
			int tail = 1;
			for(int i =1;i<c.length;i++){
				int j;
				for(j =0;j<tail;j++){
					if(c[i]==c[j]){
						break;
					}
				}
				if(j == tail){
					c[tail]=c[i];
					tail++;
						
				}
					
				
				
				
			}
			c[tail] = 0;
			for(int a =0 ; a<tail ;a++){
				System.out.print(c[a]);
				
			}
			
		}
	}
}
