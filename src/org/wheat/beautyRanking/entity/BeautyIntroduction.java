package org.wheat.beautyRanking.entity;

import com.google.gson.annotations.SerializedName;

public class BeautyIntroduction 
{
	@SerializedName("beautyId")
	private int beautyId;
	/*
	 * beauty����ʵ����
	 */
	@SerializedName("beautyName")
	private String mBeautyName;
	
	/*
	 * ����ѧУ
	 */
	@SerializedName("school")
	private String mSchool;
	
	/*
	 * ����
	 */
	@SerializedName("description")
	private String mDescription;
	
	/*
	 * avatar��·��
	 */
	@SerializedName("avatarPath")
	private String mAvatarPath;
	
	public void setBeautyName(String beautyName)
	{
		this.mBeautyName=beautyName;
	}
	
	public String getBeautyName()
	{
		return this.mBeautyName;
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
	public void setBeautyId(int beautyId){
		this.beautyId=beautyId;
	}
	public int getBeautyId(){
		return this.beautyId;
	}
}
