package org.wheat.beautyRanking.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BeautyDetail 
{
	
	/*
	 * beauty�Ĵ����ߵ绰����
	 */
	@SerializedName("createTime")
	private String mCreateTime;
	
	/*
	 * ��beauty���޵Ĵ���
	 */
	@Expose 
	@SerializedName("lat")
	private String mLat;
	
	/*
	 * ��beauty���꼶
	 */
	@Expose 
	@SerializedName("lng")
	private String mLng;
	
	/*
	 * beauty�Ĵ����ߵ绰����
	 */
	@SerializedName("userPhoneNumber")
	private String mUserPhoneNumber;
	
	/*
	 * ��beauty���޵Ĵ���
	 */
	@Expose 
	@SerializedName("praseTimes")
	private String mPraseTimes;
	
	/*
	 * ��beauty���꼶
	 */
	@Expose 
	@SerializedName("admissionYear")
	private String mAdmissionYear;
	
	/*
	 * beauty������
	 */
	@Expose 
	@SerializedName("birthday")
	private String mBirthday;
	/*
	 * beauty����ʵ����
	 */
	@Expose 
	@SerializedName("trueName")
	private String mTrueName;
	/*
	 * beauty������
	 */
	@Expose 
	@SerializedName("constellation")
	private String mConstellation;
	/*
	 * ����ѧУ
	 */
	@Expose 
	@SerializedName("school")
	private String mSchool;
	
	/*
	 * ����
	 */
	@Expose 
	@SerializedName("description")
	private String mDescription;
	
	/*
	 * avatar��·��
	 */
	@SerializedName("avatarPath")
	private String mAvatarPath;
	
	@Expose
	@SerializedName("beautyId")
	String mBeautyId;
	
	
	public void setBeautyId(String BeautyId)
	{
		this.mBeautyId=BeautyId;
	}
	
	public String getBeautyId()
	{
		return this.mBeautyId;
	}
	public void setUserPhoneNumber(String UserPhoneNumber)
	{
		this.mUserPhoneNumber=UserPhoneNumber;
	}
	
	public String getUserPhoneNumber()
	{
		return this.mUserPhoneNumber;
	}
	
	public void setPraseTimes(String mPraseTimes)
	{
		this.mPraseTimes=mPraseTimes;
	}
	
	public String getPraseTimes()
	{
		return this.mPraseTimes;
	}
	
	
	
	public void setAdmissionYear(String AdmissionYear)
	{
		this.mAdmissionYear=AdmissionYear;
	}
	
	public String getAdmissionYear()
	{
		return this.mAdmissionYear;
	}
	
	
	
	public void setBirthday(String Birthday)
	{
		this.mBirthday=Birthday;
	}
	
	public String getBirthday()
	{
		return this.mBirthday;
	}
	public void setConstellation(String Constellation)
	{
		this.mConstellation=Constellation;
	}
	
	public String getConstellation()
	{
		return this.mConstellation;
	}
	
	
	public void setTrueName(String TrueName)
	{
		this.mTrueName=TrueName;
	}
	
	public String getTrueName()
	{
		return this.mTrueName;
	}
	
	public void setSchool(String school)
	{
		this.mSchool=school;
	}
	
	public String getSchool()
	{
		return this.mSchool;
	}
	
	public void setDescription(String description)
	{
		this.mDescription=description;
	}
	
	public String getDescription()
	{
		return this.mDescription;
	}
	
	public void setAvatarPath(String path)
	{
		this.mAvatarPath=path;
	}
	
	public String getAvatarPath()
	{
		return this.mAvatarPath;
	}
	public void setCreateTime(String CreateTime)
	{
		this.mCreateTime=CreateTime;
	}
	
	public String getCreateTime()
	{
		return this.mCreateTime;
	}
	public void setLat(String Lat)
	{
		this.mLat=Lat;
	}
	
	public String getLat()
	{
		return this.mLat;
	}
	
	public void setLng(String mLngs)
	{
		this.mLng=mLng;
	}
	
	public String getLng()
	{
		return this.mLng;
	}
}
