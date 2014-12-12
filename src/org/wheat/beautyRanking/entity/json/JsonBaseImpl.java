package org.wheat.beautyRanking.entity.json;

import java.io.Serializable;

import org.wheat.beautyRanking.entity.ErrMsg;
import org.wheat.beautyRanking.loader.HttpDataLoaderServer;

import com.google.gson.annotations.SerializedName;
/**
 * @author wheat
 * @Date 14-9-14
 * @Time ����21:29
 * @deprecated �������͸��ͻ������ݷ�װ�࣬���е�����ͳһΪmCode(�������Ӧ״̬��
 * 			   mData(Ҫ���͵����ݣ����ݱ���Ҳ�ǿ���json��) mErrMsg(����˴�����Ϣ)
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
