package org.wheat.beautyRanking.entity;

import java.util.Date;

import org.wheat.beautyRanking.data.DataType;
import org.wheat.beautyRanking.data.IData;

public class PraiseRecord implements IData
{
	private static final long serialVersionUID = 1L;
	private int dataType=DataType.ENTITY_PRAISERECORD;
	//�û��ֻ���
	private String userPhoneNumber;
	//mm��id
	private int beautyID;
	//�޵��¼�
	private Date praiseTime;
	public void setUserPhoneNumber(String userPhoneNumber)
	{
		this.userPhoneNumber=userPhoneNumber;
	}
	public String getUserPhoneNumber()
	{
		return this.userPhoneNumber;
	}
	public void setbeautyID(int beautyID)
	{
		this.beautyID=beautyID;
	}
	public int getBeauty()
	{
		return this.beautyID;
	}
	public void setPraiseTime(Date praiseTime)
	{
		this.praiseTime=praiseTime;
	}
	public Date getPraiseTime()
	{
		return this.praiseTime;
	}
	@Override
	public int getDataType() 
	{
		return dataType;
	}
}
