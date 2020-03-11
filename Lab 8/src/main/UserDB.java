package main;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
	private static UserDB instance = null;
	
	private List<User> users;
	
	private UserDB() {
		users = new ArrayList<>();
	}
	
	public static UserDB getInstance() {
		if (instance == null) {
				instance = new UserDB();
		}
		return instance;
	}
	
	public void add(User user) {
		users.add(user);
	}
	
	public boolean findUser(User user) {
		for (User u : users)
			if (u.getUsername().equals(user.getUsername())) 
				return true;
		
		return false;
	}
	
	public List<User> getList() {
		return users;
	}
}