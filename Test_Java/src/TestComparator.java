import java.util.*;
public class TestComparator {
	public static void main(String args[]){
		SortedSet<String> ital1 = new TreeSet<String>();
		SortedSet<String> ital2 = new TreeSet<String>(new RevStringComparator());
		Collections.addAll(ital1,"abc","bca","cab","aaz","aabc");
		
		Collections.addAll(ital2,"abc","bca","cab");
		System.out.println(ital1);
		System.out.println(ital2);
		Iterator it = ital1.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	

}

class RevStringComparator implements Comparator<String>{
	public int compare(String s1, String s2){
		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s2);
		String rs1 = sb1.reverse().toString();
		String rs2 = sb2.reverse().toString();
		return rs1.compareTo(rs2);
	}
}
	

