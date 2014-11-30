package org.wheat.beautyRanking.entity;

import org.wheat.beautyRanking.data.DataType;
import org.wheat.beautyRanking.data.IData;

public class RequestRegisterUser implements IData
{
	private static final long serialVersionUID = 1L;
	private int dataType=DataType.REQUEST_REGISTER;
	private String userPhoneNumber;
	private String password;
	private String nickName;
	private String school;
	private int admissionYear;
	private String sex;
	private String avatarPath;
	public RequestRegisterUser(){}
	public RequestRegisterUser(String userPhoneNumber,String nickName)
	{
		this.userPhoneNumber=userPhoneNumber;
		this.nickName=nickName;
	}
	//�û�����
	public void setUserPhoneNumber(String userPhone)
	{
		this.userPhoneNumber=userPhone;
	}
	public String getUserPhoneNumber()
	{
		return this.userPhoneNumber;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return this.password;
	}
	//����
	public void setNickName(String nickName)
	{
		this.nickName=nickName;
	}
	public String getNickName()
	{
		return this.nickName;
	}
	//ѧУ
	public void setSchool(String school)
	{
		this.school=school;
	}
	public String getSchool()
	{
		return school;
	}
	//��ѧ���
	public void setAdmissionYear(int admissionYear)
	{
		this.admissionYear=admissionYear;
	}
	public int getAdmissionYear()
	{
		return this.admissionYear;
	}
	//�Ա�
	public void setSex(String sex)
	{
		this.sex=sex;
	}
	public String getSex()
	{
		return this.sex;
	}
	//ͷ��·��
	public void setAvatarPath(String avatarPath)
	{
		this.avatarPath=avatarPath;
	}
	public String getAvatarPath()
	{
		return this.avatarPath;
	}
	@Override
	public int getDataType()
	{
		return dataType;
	}
	
}
