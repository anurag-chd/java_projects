
public class TestInnerClasses {

	public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
        ShadowTest.SecondLevel s2 = new ShadowTest.SecondLevel();
        s2.methodInSecondLevel(30);
        st.printshadow();
    }
	
	
}

 class ShadowTest {

    private int x = 0;
    private int y = 2;
    public class FirstLevel {

        private int x = 1;
        //public int y = 2;

        void methodInFirstLevel(int z) {
            System.out.println("x = " + x);
            System.out.println("z = " + z);
            System.out.println("this.x = " + this.x);
          //  System.out.println("ShadowTest.x = " + ShadowTest.this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
            System.out.println("ShadowTest.this.y = " + ShadowTest.this.y);
            System.out.println("y = " + y);
        }
    }
    
    public static class SecondLevel{
    	private int x = 3;
    	void methodInSecondLevel(int z){
    		System.out.println("z = " +z);
    		System.out.println("x = " +x);
    		System.out.println("x = " +this.x);
    		//System.out.println("x = " + ShadowTest.this.x);
    		//System.out.println("y = " + y);
    	}
    }
    
    public void printshadow(){
    	System.out.println(ShadowTest.this.y);
    }

    
}