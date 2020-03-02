package predicate;

public class User {

	String name;
	String pwd;
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}
	public String getPwd() {
		return pwd;
	}
}
