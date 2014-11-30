package org.wheat.beautyRanking.entity;

import com.google.gson.annotations.SerializedName;

public class UserLogin 
{
	/*
	 * �û����ֻ���
	 */
	@SerializedName("userPhoneNumber")
	private String mUserPhoneNumber;
	
	/*
	 * �û�������
	 */
	@SerializedName("password")
	private String mPassword;
	
	/*
	 * �û��ǳ�
	 */
	@SerializedName("nikename")
	private String mNikeName;
	
	/*
	 * ѧУ
	 */
	@SerializedName("school")
	private String mSchool;
	
	/*
	 * ��ѧ���
	 */
	@SerializedName("admissionYear")
	private int mAdmissionYear;
	
	/*
	 * �Ա�
	 */
	@SerializedName("sex")
	private String mSex;
	
	public String getUserPhoneNumber()
	{
		return this.mUserPhoneNumber;
	}
	
	public void setUserPhoneNumber(String userPhoneNumber)
	{
		this.mUserPhoneNumber=userPhoneNumber;
	}
	
	public String getPassword()
	{
		return this.mPassword;
	}
	
	public void setPassword(String password)
	{
		this.mPassword=password;
	}
	
	public String getNikeName()
	{
		return this.mNikeName;
	}
	
	public void setNikeName(String nikeName)
	{
		this.mNikeName=nikeName;
	}
	
	public String getSchool()
	{
		return this.mSchool;
	}
	
	public void setSchool(String school)
	{
		this.mSchool=school;
	}
	
	public int getAdmissionYear()
	{
		return this.mAdmissionYear;
	}
	
	public void setAdmissionYear(int admissionYear)
	{
		this.mAdmissionYear=admissionYear;
	}
	
	public String getSex()
	{
		return this.mSex;
	}
	
	public void setSex(String sex)
	{
		this.mSex=sex;
	}
}
