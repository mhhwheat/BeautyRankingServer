package org.wheat.beautyRanking.loader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.wheat.beautyRanking.coders.Aes;

import Decoder.BASE64Decoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpDataLoaderServer
{
	private static final byte[] PSW = "AjGfpbbQmU7EAnkJ".getBytes();
	/*
	 * ��json��ʽ���ַ���תΪʵ�����
	 */
	public static <T> T fromJson(String json,Class<T> classOfT)
	{
		Gson gson=new GsonBuilder().create();
		return gson.fromJson(json, classOfT);
	}
	
	/*
	 * �Ѷ���תΪjson��ʽ���ַ���
	 */
	
	public static String toJson(Object object)
	{
		Gson gson=new GsonBuilder().create();
		return gson.toJson(object);
	}
	
	/**
	 * �ӵõ���get�����л�ÿͻ��˷����Ĳ����б�
	 * @param base64Code
	 * @return
	 * @throws Throwable
	 */
	public static HashMap<String, String> dencryptParamsFromGet(String base64Code) throws Throwable
	{
		if(base64Code==null)
		{
			return null;
		}
		return dencryptParamsFromPost(new BASE64Decoder().decodeBuffer(base64Code));
		
	}
	
	/**
	 * �ӵõ���post�����л�ÿͻ��˷����Ĳ����б�
	 * @param data
	 * @return
	 */
	public static HashMap<String,String> dencryptParamsFromPost(byte[] src) throws Throwable
	{
		if(src==null)
		{
			return null;
		}
		int length=src.length;
		byte[] iv=subBytes(src, 0, 16);
		byte[] buff=subBytes(src, 16, length-16);
		byte[] data=Aes.decrypt(buff, PSW, iv);
		String strBuff=new String(data,"UTF-8");
		//String[] strArray=strBuff.split("&");
		String[] strArray=URLDecoder.decode(strBuff,"UTF-8").split("&");
		HashMap<String, String> out=new HashMap<String, String>();
		for(int i=0;i<strArray.length;i++)
		{
			String[] kv=strArray[i].split("=");
			out.put(kv[0], kv[1]);
		}
		return out;
	}
	
	/**
     * ��һ��byte[]�����н�ȡһ����
     * @param src
     * @param begin
     * @param count
     * @return
     */
	public static byte[] subBytes(byte[] src,int begin,int count)
	{
		byte[] bs=new byte[count];
		for(int i=begin;i<begin+count;i++)
			bs[i-begin]=src[i];
		return bs;
	}
	/**
	 * ��http�����ʵ���л�ȡ�ͻ����ύ�Ĳ���
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static HashMap<String, String> getParamsFromEntity(HttpServletRequest request) throws IOException
	{
		InputStream is=request.getInputStream();
		int streamLength=request.getContentLength();
		System.out.println("�������ݳ��ȣ�"+streamLength);
		byte[] data=new byte[streamLength];
		int count=0;
		int len=0;
		while((len=is.read(data, count, streamLength-count))!=-1)
		{
			count=+len;
		}
		is.close();
		HashMap<String, String> postData=null;
		try {
			postData=HttpDataLoaderServer.dencryptParamsFromPost(data);
			return postData;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return postData;
	}
	
}

