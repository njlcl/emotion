package cn.edu.njupt.domain;

public class SelectData {
	private String userName;
	private String timeStamp;
	
	
	public String acclData;
	public String gyroData;
	
	
	private String skinResData;
	private String heartRateData;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getAcclData() {
		return acclData;
	}
	public void setAcclData(String acclData) {
		this.acclData = acclData;
	}
	public String getGyroData() {
		return gyroData;
	}
	public void setGyroData(String gyroData) {
		this.gyroData = gyroData;
	}
	public String getSkinResData() {
		return skinResData;
	}
	public void setSkinResData(String skinResData) {
		this.skinResData = skinResData;
	}
	public String getHeartRateData() {
		return heartRateData;
	}
	public void setHeartRateData(String heartRateData) {
		this.heartRateData = heartRateData;
	}
	
	

}
