import java.util.*;
public class TestHashSet {
	public static void main(String args[]){
		
		Set <String> s = new HashSet<String>();
		Collections.addAll(s,"a","b","c","d","a");
		System.out.println(s);
		Iterator<String> i = s.iterator();
		
	}

}
