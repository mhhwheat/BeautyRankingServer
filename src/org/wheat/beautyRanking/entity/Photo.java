package org.wheat.beautyRanking.entity;


import com.google.gson.annotations.SerializedName;
public class Photo  
{

	//�����ĸ�beauty��beautyId
	@SerializedName("beautyId")
	private String beautyId;
	//��Ƭid
	@SerializedName("commentCount")
	private int commentCount;
	//mm��id
	@SerializedName("praiseCount")
	private int praiseCount;
	//��Ƭ�ڱ��ص�·��
	@SerializedName("photoPath")
	private String photoPath;
	//�û��ֻ�����(�ϴ�����Ƭ���û�)
	@SerializedName("userPhoneNumber")
	private String userPhoneNumber;
	//�ϴ�ʱ��
	@SerializedName("uploadTime")
	private String uploadTime;
	public Photo(){}
	public Photo(int commentCount,int praiseCount,String photoPath,String userPhoneNumber,String uploadTime)
	{
		this.commentCount=commentCount;
		this.praiseCount=praiseCount;
		this.photoPath=photoPath;
		this.userPhoneNumber=userPhoneNumber;
		this.uploadTime=uploadTime;
	}
	public void setBeautyId(String beautyId){
		this.beautyId=beautyId;
	}
	public String getBeautyId(){
		return this.beautyId;
	}
	public void setPraiseCount(int praiseCount)
	{
		this.praiseCount=praiseCount;
	}
	public int getPraiseCount()
	{
		return this.praiseCount;
	}
	public void setCommentCount(int commentCount)
	{
		this.commentCount=commentCount;
	}
	public int getCommentCount()
	{
		return this.commentCount;
	}
	public void setPhotoPath(String photoPath)
	{
		this.photoPath=photoPath;
	}
	public String getPhotoPath()
	{
		return this.photoPath;
	}
	public void setUserPhoneNumber(String userPhoneNumber)
	{
		this.userPhoneNumber=userPhoneNumber;
	}
	public String getUserPhoneNumber()
	{
		return this.userPhoneNumber;
	}
	public void setUploadTime(String uploadTime)
	{
		this.uploadTime=uploadTime;
	}
	public String getUploadTime()
	{
		return this.uploadTime;
	}
	
}
