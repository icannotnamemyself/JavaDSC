package aaa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class Main {
	public static void main(String[] args) {
//		testHashMap();
		
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i < 11;i++) {
			list.add(i);
		}
		System.out.println(list);
		
		list.remove(4);
		
		System.out.println(list);
		
		
	}

	private static void testHashMap() {
		HashMap<String, String> phoneBookHashMap = new HashMap<String, String>();
		phoneBookHashMap.put("google", "1234556");
		phoneBookHashMap.put("microsoft", "1234112556");
		System.out.println(phoneBookHashMap.remove("google"));
		System.out.println(phoneBookHashMap.get("microsoft"));
	}
}
