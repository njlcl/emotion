package cn.edu.njupt.domain;

/**
 * Created by abc on 2016/10/29.
 */

public class PhysiologyComm1 implements Protocol{
	public String userName;
	public long timeStamp;
	public float[] acclData;
	public float[] gyroData;
	public int[] skinResData;
	public int[] heartRateData;

    public static final String SERVICE_TYPE = "PhysiologyComm1";
    @Override
    public String getServiceType() {
        return SERVICE_TYPE;
    }

    

    public PhysiologyComm1(String userName, long timeStamp, float[] acclData,float[] gyroData,
			int[] skinResData, int[] heartRateData) {
		super();
		this.userName = userName;
		this.timeStamp = timeStamp;
		this.acclData = acclData;
		this.gyroData = gyroData;
		this.skinResData = skinResData;
		this.heartRateData = heartRateData;
	}



	public PhysiologyComm1() {}

}