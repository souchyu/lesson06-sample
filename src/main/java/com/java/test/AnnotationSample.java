package com.java.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnnotationSample {

	private String fieldA;

	public String getFieldA() {
		return this.fieldA;
	}

	@MethodValue(value = "value from annotation")
	public void setFieldA(String fieldA) {
		this.fieldA = fieldA;
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		AnnotationSample sample = new AnnotationSample();
		String value = sample.getClass().getMethod("setFieldA", String.class).getAnnotation(MethodValue.class).value();
		sample.setFieldA(value);

		log.info("annotation value: {}", sample.getFieldA());
	}

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MethodValue {
	String value();
}