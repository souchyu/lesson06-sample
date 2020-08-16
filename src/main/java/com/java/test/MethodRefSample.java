package com.java.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodRefSample {

	public static void main(String[] args) {

		Consumer<String> func1 = text -> System.out.println(text);
		func1.accept("Method ref01");

		Consumer<String> func2 = System.out::println;
		func2.accept("Method ref02");

//		List<Company> companies = Arrays.asList(new Company("company a"), new Company("company b"));
//		companies.forEach(company -> company.print());
//		companies.forEach(Company::print);

		List<String> companyNames = Arrays.asList("company a", "company b");
//		companyNames.stream().map(name -> new Company(name)).forEach(company -> company.print());
		companyNames.stream().map(Company::new).forEach(Company::print);
	}
}

class Company {
	private String name;

	public Company(String name) {
		this.name = name;
	}

	public void print() {
		System.out.println(this.name);
	}
}
