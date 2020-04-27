package xyz.theo;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> mArrayList = new ArrayList<Integer>();  
		mArrayList.add(1);
		mArrayList.add(2);
		mArrayList.remove(1);
		
		mArrayList.add(3);
		mArrayList.add(4);
		
		mArrayList.add(2, 7);
		System.out.println(mArrayList);
		mArrayList.add(1, 8);
		System.out.println(mArrayList);
		mArrayList.clear();
		System.out.println(mArrayList);
		
	}

}
