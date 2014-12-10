package org.wheat.beautyRanking.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BeautyIntroductionList 
{
	/*
	 * 简介列表
	 * BeautyIntroduction本身可以json化，但为了传送一个列表数据，需要封装List为一个可以json的类
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
