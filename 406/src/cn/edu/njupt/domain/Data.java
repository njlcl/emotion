package cn.edu.njupt.domain;

import java.util.Arrays;

public class Data {
	private String userName;
	private long timeStamp;
	
	
	public float[] acclData;
	public float[] gyroData;
	
	
	private int[] skinResData;
	private int[] heartRateData;
	
	
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public long getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}



	public float[] getAcclData() {
		return acclData;
	}



	public void setAcclData(float[] acclData) {
		this.acclData = acclData;
	}



	public float[] getGyroData() {
		return gyroData;
	}



	public void setGyroData(float[] gyroData) {
		this.gyroData = gyroData;
	}



	public int[] getSkinResData() {
		return skinResData;
	}



	public void setSkinResData(int[] skinResData) {
		this.skinResData = skinResData;
	}



	public int[] getHeartRateData() {
		return heartRateData;
	}



	public void setHeartRateData(int[] heartRateData) {
		this.heartRateData = heartRateData;
	}



	@Override
	public String toString() {
		return "Data [userName=" + userName + ", timeStamp=" + timeStamp
				+ ", acclData=" + Arrays.toString(acclData) + ", gyroData="
				+ Arrays.toString(gyroData) + ", skinResData="
				+ Arrays.toString(skinResData) + ", heartRateData="
				+ Arrays.toString(heartRateData) + "]";
	}
	

	
	
	
}
