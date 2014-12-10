package org.wheat.beautyRanking.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadFileTools {

	public static void UploadOriginPhotoHttpClient(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println("in do post method0");
		String PhotoName = request.getParameter("PhotoName");
		String filePath = "D:/BeautyRankingPhoto/recive_photo/";
		// 定义上载文件的最大字节
		int MAX_SIZE = 102400 * 102400;
		// 声明文件读入类
		DataInputStream in = null;
		FileOutputStream fileOut = null;
		// 取得客户端上传的数据类型
		String contentType = request.getContentType();
		if (contentType.indexOf("binary/octet-stream") >= 0) {
			// 读入上传的数据
			in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			// 如果图片过大
			if (formDataLength > MAX_SIZE) {
				String errormsg = ("上传的文件字节数不可以超过" + MAX_SIZE);
				System.out.println(errormsg);
				return;
			}
			// 保存上传文件的数据
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			// 上传的数据保存在byte数组
			System.out.println("in do post method1");
			while (totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			System.out.println("in do post method2");
			String fileName = filePath + PhotoName;
			// 检查上载文件的目录是否存在
			File fileDir = new File(filePath);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			// 创建文件的写出类
			fileOut = new FileOutputStream(fileName);
			// 保存文件的数据
			fileOut.write(dataBytes);
			fileOut.close();
			OutputStream out = response.getOutputStream();
			out.write("success".getBytes("UTF-8"));
			out.close();
		}
	}
}
