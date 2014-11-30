package org.wheat.beautyRanking.entity;

import org.wheat.beautyRanking.data.DataType;
import org.wheat.beautyRanking.data.IData;

public class Photo implements IData
{
	private static final long serialVersionUID = 1L;
	private int dataType=DataType.ENTITY_PHOTO;
	//��Ƭid
	private int photoID;
	//mm��id
	private int beautyID;
	//��Ƭ�ڱ��ص�·��
	private String photoPath;
	//�û��ֻ�����(�ϴ�����Ƭ���û�)
	private String userPhoneNumber;
	//�ϴ�ʱ��
	private String uploadTime;
	public Photo(int photoID,int beautyID,String photoPath,String userPhoneNumber,String uploadTime)
	{
		this.photoID=photoID;
		this.beautyID=beautyID;
		this.photoPath=photoPath;
		this.userPhoneNumber=userPhoneNumber;
		this.uploadTime=uploadTime;
	}
	public void setPhotoID(int photoID)
	{
		this.photoID=photoID;
	}
	public int getPhotoID()
	{
		return this.photoID;
	}
	public void setBeautyID(int beautyID)
	{
		this.beautyID=beautyID;
	}
	public int getBeautyID()
	{
		return this.beautyID;
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
	@Override
	public int getDataType() 
	{
		return dataType;
	}
	
}
