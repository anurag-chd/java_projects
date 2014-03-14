
 class Ex2 {
	 
	public static void main(String args[]){
		Dog d = new Dog();
		Dog d_new = new Dog();
		System.out.println(d.hashCode());
		System.out.println(d_new.hashCode());
		if(d.equals(d_new)){
			System.out.println("Object Equality");
		}
		if(d == d_new){
			System.out.println("Reference Equality");
		}
		Dog[] d1 = new Dog[10];
		d.name = "as";
		d1[0] = new Dog();
		d1[0].bark();
		d1[0].name = "bs";
		d.bark();
		d1[0].bark();
		
		
		d1[1] = d;
		d1[1].bark();
		d1[1].name = "cs";
		d1[1].bark();
		d.name ="ds";
		d1[1].bark();
		
	}

}

class Dog{
	String name;
	public Dog(){
		name = "Dog";
	}
	public void bark(){
		System.out.println(this.name+"Barks");
	}
	
	public boolean equals(Dog d){
		if(this.name.equals(d.name))
			return true;
		else
			return false;
	}
	
}