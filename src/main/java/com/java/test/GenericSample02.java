package com.java.test;

import lombok.AllArgsConstructor;
import lombok.Data;

public class GenericSample02 {

	public static void main(String[] args) {
		Repo<User> repo = new UserRepo();
		User user = repo.get();
		System.out.println(String.format("User[id:%d, name:%s]", user.getId(), user.getName()));
	}

	private <T> T getT(T t) {
		return t;
	}
}

interface Repo<T> {
	T get();
}

class UserRepo implements Repo<User> {

	@Override
	public User get() {
		return new User(1, "name001");
	}
}

@Data
@AllArgsConstructor
class User {
	private int id;
	private String name;
}

