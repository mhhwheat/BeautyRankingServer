package org.wheat.beautyRanking.entity.json;

import java.io.Serializable;

import org.wheat.beautyRanking.loader.HttpDataLoaderServer;

import com.google.gson.annotations.SerializedName;
/**
 * @author wheat
 * @Date 14-9-14
 * @Time 下午21:29
 * @description 用来传送给客户端数据封装类，所有的数据统一为mCode(服务端响应状态）
 * 			   mData(要传送的数据，数据本身也是可以json化) mErrMsg(服务端错误信息)
 */
public class JsonBaseImpl <T> implements JsonBase<T>,Serializable
{

	  	@SerializedName("c")
	  	private int mCode = -1;

	  	@SerializedName("d")
	  	private T mData;

	  	@SerializedName("err")
	  	private String mErrMsg;

	  	@Override
	  	public int getCode() {
	        return mCode;
	    }

	    @Override
	    public void setCode(int code) {
	        mCode = code;
	    }

	    @Override
	    public T getData() {
	        return mData;
	    }

	    @Override
	    public void setData(T data) {
	        mData = data;
	    }

	    public String  getErrMsg() {
	        return mErrMsg;
	    }

	    public void setErrMsg(String errMsg) {
	        mErrMsg = errMsg;
	    }

	    @Override
	    public String getMsg() {
	        return this.mErrMsg;
	    }

	    @Override
	    public void setMsg(String msg) {
	        this.mErrMsg=msg;
	    }

	    @Override
	    public String toCacheString() 
	    {
	    	return HttpDataLoaderServer.toJson(this);
	    }
}
