package okjsp;

/**
 * @Project : okjsp
 * @FileName : user.java
 * @Date : 2014. 8. 13.
 * @Author : SKLEE
 * @Note :
 */

public class User {
	private String id;
	private String password;
	private String confirmPassword;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isOK() {
		boolean isOK = (id != null) && id.equals("admin") && (password != null)
				&& password.equals("okpass");
		return isOK;
	}
}
