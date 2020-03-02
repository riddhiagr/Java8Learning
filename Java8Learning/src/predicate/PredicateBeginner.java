package predicate;

import java.util.List;
import java.util.function.Predicate;

public class PredicateBeginner {

	public void getNamesWithK(List<String> names) {
		Predicate<String> checkNameswWithK= string -> string.startsWith("K");
		Predicate<String> checkNameswWithk= string -> string.startsWith("k");
		
		for(String name : names) {
			if(checkNameswWithK.or(checkNameswWithk).test(name)) {
				System.out.println(name);
			}
		}
	}
	
	public void removeNullAndEmpty(List<String> list) {
		Predicate<String> removeNullAndEmpty = value -> value != null && !value.isEmpty();
		for(String val : list) {
			if(removeNullAndEmpty.test(val))
				System.out.println(val);
		}
	}
	
	public void validateUser(User user) {
		
	}
}
