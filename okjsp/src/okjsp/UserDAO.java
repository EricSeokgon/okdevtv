package okjsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : okjsp
 * @FileName : UserDAO.java
 * @Date : 2014. 8. 13.
 * @Author : SKLEE
 * @Note :
 */

public class UserDAO {
	static List<User> list = new ArrayList<User>();

	/**
	 * 
	 */
	public static void save(User user) {
		list.add(user);
	}

	public static int size() {
		return list.size();
	}

}
