package predicate;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class UsersData {

	Collection<User> users;
	public UsersData() {
	users = new HashSet<>();
	}
	
	public void fillData(String name, String pwd) {
		users.add(new User(name, pwd));
	}
	
	public User validateData(String name, String pwd) {
		Predicate<User> validate = val -> users.contains(val);
		return null;
	}
	
}
