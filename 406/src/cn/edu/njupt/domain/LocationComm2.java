package cn.edu.njupt.domain;

/**
 * Created by abc on 2016/12/7.
 */

public class LocationComm2 implements Protocol {

    public static final String SERVICE_TYPE = "LocationComm2";

    public boolean isSuccess;

    @Override
    public String getServiceType() {
        return SERVICE_TYPE;
    }
}
