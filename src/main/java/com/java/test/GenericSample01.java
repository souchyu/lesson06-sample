package com.java.test;

import java.util.ArrayList;
import java.util.List;

public class GenericSample01 {

	public static void main(String[] args) {

		@SuppressWarnings({ "rawtypes", "unused" })
		List objList = new ArrayList();

		List<Integer> list = new ArrayList<>();
		list.add(100);
		list.add(200);
//		list.add("abc");
		list.add(300);

		for (Integer intItem : list) {
			System.out.println(intItem.intValue());
		}
	}

}
