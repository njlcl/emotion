package cn.edu.njupt.domain;

public class Register1{

	public String userName;
    public String password;
    public String nickname;

    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Register1(String userName, String password, String nickname) {
        this.userName = userName;
        this.password = password;
        this.nickname = nickname;
    }


	public static final String SERVICE_TYPE = "Register1";
    public String getServiceType() {
        return SERVICE_TYPE;
    }
}
