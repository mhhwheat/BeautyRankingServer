package org.wheat.beautyRanking.entity;

import org.wheat.beautyRanking.data.DataType;
import org.wheat.beautyRanking.data.IData;




public class Beauty implements IData
{
	/**
	 * @author wheat
	 */
	private static final long serialVersionUID = 1L;
	private int dataType=DataType.ENTITY_BEAUTY;
	//MM��ID
	private int beautyID;
	//ͷ���·��
	private String avatarPath;
	//MM����ʵ����
	private String trueName;
	//�ϴ���MM��Ϣ��
	private String userPhoneNumber;
	//�޵Ĵ���
	private Long praseTimes;
	//MM��ѧУ
	private String school;
	//��ѧ���
	private String admissionYear;
	//����ʱ��
	private String birthday;
	//����
	private String constellation;
	//����
	private String description;
	public Beauty(int beautyID,String userPhoneNumber,String trueName,Long praseTimes,String school,String description)
	{
		this.beautyID=beautyID;
		this.userPhoneNumber=userPhoneNumber;
		this.trueName=trueName;
		this.praseTimes=praseTimes;
		this.school=school;
		this.description=description;
	}
	public void setBeautyID(int beautyID)
	{
		this.beautyID=beautyID;
	}
	public int getBeautyID()
	{
		return this.beautyID;
	}
	public void setAvatarPath(String avatarPath)
	{
		this.avatarPath=avatarPath;
	}
	public String getAvatarPath()
	{
		return this.avatarPath;
	}
	public void setTrueName(String trueName)
	{
		this.trueName=trueName;
	}
	public String getTrueName()
	{
		return trueName;
	}
	public void setUserPhoneNumber(String userPhoneNmuber)
	{
		this.userPhoneNumber=userPhoneNmuber;
	}
	public String getUserPhoneNumber()
	{
		return this.userPhoneNumber;
	}
	public void setPraseTimes(Long praseTimes)
	{
		this.praseTimes=praseTimes;
	}
	public Long getPraseTimes()
	{
		return this.praseTimes;
	}
	public void setSchool(String school)
	{
		this.school=school;
	}
	public String getSchool()
	{
		return school;
	}
	public void setAdmissionYear(String admissionYear)
	{
		this.admissionYear=admissionYear;
	}
	public String getAdmissionYear()
	{
		return admissionYear;
	}
	public void setBirthday(String birthday)
	{
		this.birthday=birthday;
	}
	public String getBirthday()
	{
		return this.birthday;
	}
	public void setConstellation(String constellation)
	{
		this.constellation=constellation;
	}
	public String getConstellation()
	{
		return this.constellation;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public String getDescription()
	{
		return this.description;
	}
	@Override
	public int getDataType() 
	{
		return dataType;
	}
}
