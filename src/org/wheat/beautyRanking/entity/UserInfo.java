package org.wheat.beautyRanking.entity;

import com.google.gson.annotations.SerializedName;

public class UserInfo {

	/*
	 * �û��ֻ�
	 */
	@SerializedName("userPhoneNumber")
	private String mUserPhoneNumber;
	
	/*
	 * �ǳ�
	 */
	@SerializedName("nikeName")
	private String mNikeName;
	/*
	 * ��ע��
	 */
	@SerializedName("focusNum")
	private int focusNum;
	/*
	 * ���������� 
	 */
	@SerializedName("createNum")
	private int createNum;
	public String getmUserPhoneNumber() {
		return mUserPhoneNumber;
	}
	public void setmUserPhoneNumber(String mUserPhoneNumber) {
		this.mUserPhoneNumber = mUserPhoneNumber;
	}
	public String getmNikeName() {
		return mNikeName;
	}
	public void setmNikeName(String mNikeName) {
		this.mNikeName = mNikeName;
	}
	public int getFocusNum() {
		return focusNum;
	}
	public void setFocusNum(int focusNum) {
		this.focusNum = focusNum;
	}
	public int getCreateNum() {
		return createNum;
	}
	public void setCreateNum(int createNum) {
		this.createNum = createNum;
	}
	
}
