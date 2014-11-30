package org.wheat.beautyRanking.entity;

import com.google.gson.annotations.SerializedName;

public class User 
{
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
	 * ѧУ
	 */
	@SerializedName("school")
	private String mSchool;
	
	/*
	 * �Ա�
	 */
	@SerializedName("sex")
	private String mSex;
	
	/*
	 * ��ѧ���
	 */
	@SerializedName("admissionYear")
	private int mAdmissionYear;
	
	public void setUserPhoneNumber(String userPhoneNumber)
	{
		this.mUserPhoneNumber=userPhoneNumber;
	}
	
	public String getUserPhoneNumber()
	{
		return this.mUserPhoneNumber;
	}
	
	public void setNikename(String nikeName)
	{
		this.mNikeName=nikeName;
	}
	
	public String getNikename()
	{
		return this.mNikeName;
	}
	
	public void setSchool(String school)
	{
		this.mSchool=school;
	}
	
	public String getSchool()
	{
		return this.mSchool;
	}
	
	public void setSex(String sex)
	{
		this.mSex=sex;
	}
	
	public String getSex()
	{
		return this.mSex;
	}
	
	public void setAdmissionYear(int admissionYear)
	{
		this.mAdmissionYear=admissionYear;
	}
	
	public int getAdmissionYear()
	{
		return this.mAdmissionYear;
	}
}
