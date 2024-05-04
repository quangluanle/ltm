package Model;

public class Users {
	private int user_id;
	private String phoneNumber;
	private String password;
	private String email;
	private int role_id;
	private boolean state;

	public Users() {
	}

	public Users(String phoneNumber, String password, String email, int role_id, boolean state) {
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.email = email;
		this.role_id = role_id;
		this.state = state;
	}

	public Users(int user_id, String phoneNumber, String password, String email, int role_id) {
		this.user_id = user_id;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.email = email;
		this.role_id = role_id;
	}
	public Users(int user_id, String phoneNumber, String password, String email, int role_id, boolean state) {
		this.user_id = user_id;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.email = email;
		this.role_id = role_id;
		this.state = state;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", phoneNumber=" + phoneNumber + ", password=" + password + ", email="
				+ email + ", role_id=" + role_id + "]";
	}

}
