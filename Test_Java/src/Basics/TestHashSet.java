package Basics;
import java.util.*;
public class TestHashSet {
	public static void main(String args[]){
		/*char a = 'a';
		int b = a;
		System.out.println(b);*/
		Set <String> s = new HashSet<String>();
		Collections.addAll(s,"a","b","c","d","a");
		List<String> list = new ArrayList<String>();
		Collections.addAll(list,"a","b","c","d","a");
		System.out.println(list);
		//list.subList(0,2).clear();
		System.out.println(list.subList(1,4).indexOf("b"));
		System.out.println(list.indexOf("b"));
		//System.out.println(list.get(0));
		ListIterator<String> li = list.listIterator(list.size());
		ListIterator<String> li2 = list.listIterator();
		/*System.out.println(li.nextIndex());
		System.out.println(li.previousIndex());
		System.out.println(li2.nextIndex());
		System.out.println(li2.previousIndex());*/
		String a[] = s.toArray(new String[s.size()]);
		System.out.println(s);
		Iterator<String> i = s.iterator();
		
	}

}
