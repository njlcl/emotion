package cn.edu.njupt.domain;

/**
 * Created by abc on 2016/10/29.
 */

public class PhysiologyComm2 implements Protocol{

    public boolean isSuccess;

    public static final String SERVICE_TYPE = "PhysiologyComm2";
    @Override
    public String getServiceType() {
        return SERVICE_TYPE;
    }

    @Override
    public String toString() {
        return "isSuccess = " + isSuccess;
    }
}