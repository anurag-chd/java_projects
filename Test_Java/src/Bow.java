
public class Bow {
	public static void main(String args[]){
		Friend A = new Friend("Anurag","Mrinal");
		Friend B = new Friend("Mrinal","Anurag");
		Thread C = new Thread(A);
		Thread D = new Thread(B);
		C.start();
		D.start();
	}

}

class Friend implements Runnable{
	String name;
	String friend_name;
	public Friend(String name,String friend_name){
		this.name = name;
		this.friend_name = friend_name;
	}
	public void run(){
		Friend A = new Friend(this.friend_name,this.name);
		while(true){
			
			friend_bow( A);
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}	
			}
		}
	synchronized public void friend_bow(Friend A){
		System.out.println(this.name+" Bows to "+A.name);
		A.bow_again(this);
	}
	
	synchronized public void bow_again(Friend A){
		System.out.println(this.name+" Bows back to"+A.name);
	}

	
}