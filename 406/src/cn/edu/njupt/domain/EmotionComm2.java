package cn.edu.njupt.domain;

/**
 * Created by abc on 2016/10/29.
 */

public class EmotionComm2 implements Protocol{
    public String emotionType;
    public int requestInfoType;

    public static final String SERVICE_TYPE = "EmotionComm2";
    @Override
    public String getServiceType() {
        return SERVICE_TYPE;
    }
}