package Basics;

public class AnonymousClassExample {

	public static void main(String args[]){
		Anon anon = new Anon();
		anon.printStr();
	}
	
}

class Anon{
	public static String  str= "Hello";
	interface helloWorld{
		public void greeting();
		public void greetSomeone(String someone);
	}
	public void printStr(){
		final String str2 = "World";
		class EnglishMen implements helloWorld{
			String eng = "from England";
			public void greeting(){
				greetSomeone(eng);
			}
			public void greetSomeone(String someone){
				System.out.println(str + str2 + someone);
			}
		}
		
		helloWorld english = new EnglishMen();
		
		helloWorld china = new helloWorld(){
			String chinese = "from China";
			public void greeting(){
				greetSomeone(chinese);
			}
			public void greetSomeone(String someone){
				System.out.println(str + str2 + someone);
			}
		};
		
		english.greeting();
		china.greeting();
		
	
		
	}
	
}