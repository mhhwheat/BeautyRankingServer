package org.wheat.beautyRanking.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BeautyIntroductionList 
{
	/*
	 * ����б�
	 * BeautyIntroduction�������json������Ϊ�˴���һ���б����ݣ���Ҫ��װListΪһ������json����
	 */
	@SerializedName("introdutionList")
	private List<BeautyIntroduction> mIntroductionList;
	
	public void setIntroductionList(List<BeautyIntroduction> list)
	{
		this.mIntroductionList=list;
	}
	
	public List<BeautyIntroduction> getIntroductionList()
	{
		return this.mIntroductionList;
	}
}
