
public class Ex1 {
	public static void main(String args []){
		int beerNum = 10;
		String word = "bottles";
		
		
		while(beerNum > 0){
			if(beerNum == 1){
				word = "bottle";
			}
			System.out.println(beerNum + " " + word + "of beer on the wall ");
			System.out.println(beerNum + " " + word + "of beer");
			System.out.println("Take one down");
			System.out.println("pass it around");
			beerNum = beerNum - 1;
			/*
			if(beerNum > 0){
				System.out.println(beerNum + " " + word + "of beer on the wall ");
			}
			*/
			if(beerNum == 0){
				System.out.println("No more bottlesof beer on the wall ");
			}
		}
	}

}
