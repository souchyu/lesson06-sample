package com.java.test;


class OuterClass {
	private String str = "Outer class field value";
	private static String staticStr = "Outer class static field value";
	class InnerClass {
		public void print() {
			System.out.println("Inner class");
			System.out.println(str);
			System.out.println(staticStr);
		}
	}

	static class StaticInnerClass {
		public void print() {
			System.out.println("Inner static class");
//			System.out.println(str);
			System.out.println(staticStr);
		}

		public static void staticPrint() {
			System.out.println("Static Inner class, static method");
			System.out.println(staticStr);
		}
	}

}

public class NestClassSample {

	public static void main(String[] args) {
		OuterClass outClass = new OuterClass();

		OuterClass.InnerClass innerClass = outClass.new InnerClass();
		innerClass.print();

		OuterClass.StaticInnerClass staticInner = new OuterClass.StaticInnerClass();
		staticInner.print();

		OuterClass.StaticInnerClass.staticPrint();

	}
}
