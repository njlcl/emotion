package cn.edu.njupt.domain;

/**
 * Created by abc on 2016/10/29.
 */

public class Register2 implements Protocol{
    public boolean isRegister;
    public String comment;

    public static final String SERVICE_TYPE = "Register2";
    @Override
    public String getServiceType() {
        return SERVICE_TYPE;
    }
}