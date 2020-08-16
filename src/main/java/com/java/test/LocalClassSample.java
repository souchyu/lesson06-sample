package com.java.test;

import java.util.function.Consumer;

public class LocalClassSample {


	public void methodOuter() {
		class LocalClass {
			void method() {
			}
		}

		new LocalClass().method();
	}

	public void nonameMethod() {
		new MyInterface() {
			@Override
			public void methodA() {

			}
		}.methodA();

		Consumer consumer = new Consumer<String>() {
			@Override
			public void accept(String t) {
			}
		};
		consumer.accept("aaaa");
		consumer.accept("bbbb");
	}

	public static void main(String[] args) {

	}

}

interface MyInterface {
	void methodA();
}