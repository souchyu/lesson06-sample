package com.java.test;

import java.util.function.Function;

public class LamdaSample {

	public static void print(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		Function<String, String> f1 = new MyFunction();
		print(f1.apply("function1"));
		
		print(new Function<String, String>() {
			@Override
			public String apply(String t) {
				return "MyFunction: " + t;
			}
		}.apply("function2"));

		Function<String, String> f3 = new Function<String, String>() {
			@Override
			public String apply(String t) {
				return "MyFunction: " + t;
			}
		};
		print(f3.apply("function3-1"));
		print(f3.apply("function3-2"));

		Function<String, String> f4 = (String t) -> {
			return "MyFunction: " + t;
		};
		print(f4.apply("function4"));

		Function<String, String> f5 = (String t) -> "MyFunction: " + t;
		print(f5.apply("function5"));

		Function<String, String> f6 = (t) -> "MyFunction: " + t;
		print(f6.apply("function6"));

	}

}

class MyFunction implements Function<String, String> {
	@Override
	public String apply(String t) {
		return "MyFunction: " + t;
	}
}
