package org.wheat.beautyRanking.entity;

import java.util.Date;

import com.google.gson.annotations.SerializedName;


public class Comment
{
	//��ƬID
	@SerializedName("photoId")
	private int photoID;
	
	//�û��ֻ���
	@SerializedName("userPhoneNumber")
	private String userPhoneNumber;
	
	//�û�ͷ���ַ
	@SerializedName("userAvatar")
	private String userAvatar;
	
	//�û��ǳ�
	@SerializedName("userNickName")
	private String userNickName;
	
	//����ʱ��
	@SerializedName("commentTime")
	private Date commentTime;
	
	//���۵�����
	@SerializedName("commentContent")
	private String commentContent;
	
	public void setPhotoID(int photoID)
	{
		this.photoID=photoID;
	}
	
	public int getPhotoID()
	{
		return photoID;
	}
	
	public void setUserPhoneNumber(String userPhoneNumber)
	{
		this.userPhoneNumber=userPhoneNumber;
	}
	
	public String getUserPhoneNumber()
	{
		return this.userPhoneNumber;
	}
	
	public void setUserAvatar(String userAvatar)
	{
		this.userAvatar=userAvatar;
	}
	
	public String getUserAvatar()
	{
		return this.userAvatar;
	}
	
	public void setUserNickName(String userNickName)
	{
		this.userNickName=userNickName;
	}
	
	public String getUserNickName()
	{
		return this.userNickName;
	}
	
	public void setCommentTime(Date commentTime)
	{
		this.commentTime=commentTime;
	}
	
	public Date getCommentTime()
	{
		return this.commentTime;
	}
	
	public void setCommentContent(String commentContent)
	{
		this.commentContent=commentContent;
	}
	
	public String getCommentContent()
	{
		return this.commentContent;
	}
}
