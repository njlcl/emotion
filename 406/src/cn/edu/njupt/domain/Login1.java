package cn.edu.njupt.domain;

/**
 * Created by abc on 2016/10/29.
 */

public class Login1 implements Protocol{
    public String userName;
    public String password;

    public static final String SERVICE_TYPE = "Login1";
    @Override
    public String getServiceType() {
        return SERVICE_TYPE;
    }

    public Login1(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Login1() {}

}