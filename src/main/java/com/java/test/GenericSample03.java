package com.java.test;

public class GenericSample03 {

	public static void main(String[] args) {

		ClassSample<Integer> cs1 = new ClassSample<>(100);
		Integer i = cs1.getT();
		System.out.println(i);

		ClassSample<? extends Number> cs2 = new ClassSample<>(200);
		Number n1 = cs2.getT();
		System.out.println(n1);

		ClassSample<? super Integer> cs3 = new ClassSample<>(300);
		Object n2 = cs3.getT();
		System.out.println(n2);
	}

}

class ClassSample<T> {
	private T t;

	public ClassSample(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}
}