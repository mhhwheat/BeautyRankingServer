package org.wheat.beautyRanking.loader;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

public class JsonStreamToObject {
	public static Object jsonStreamToObject(HttpServletRequest request,Class classType) {
		InputStream is;
		Object object=null;
		try {
			is = request.getInputStream();

			int streamLength = request.getContentLength();
			System.out.println("请求数据长度：" + streamLength);
			byte[] data = new byte[streamLength];
			int count = 0;
			int len = 0;
			while ((len = is.read(data, count, streamLength - count)) != -1) {
				count = +len;
			}
			if(count ==0)return null;
			is.close();
//			String  jsonStrTemp = new String(data);
			String jsonStr = new String (data,"utf-8");//,"UTF-8");//
			System.out.println(jsonStr);
			object =  HttpDataLoaderServer.fromJson(jsonStr, classType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

}
