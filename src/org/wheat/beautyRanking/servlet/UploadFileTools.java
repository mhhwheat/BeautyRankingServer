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
		// ���������ļ�������ֽ�
		int MAX_SIZE = 102400 * 102400;
		// �����ļ�������
		DataInputStream in = null;
		FileOutputStream fileOut = null;
		// ȡ�ÿͻ����ϴ�����������
		String contentType = request.getContentType();
		if (contentType.indexOf("binary/octet-stream") >= 0) {
			// �����ϴ�������
			in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			// ���ͼƬ����
			if (formDataLength > MAX_SIZE) {
				String errormsg = ("�ϴ����ļ��ֽ��������Գ���" + MAX_SIZE);
				System.out.println(errormsg);
				return;
			}
			// �����ϴ��ļ�������
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			// �ϴ������ݱ�����byte����
			System.out.println("in do post method1");
			while (totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			System.out.println("in do post method2");
			String fileName = filePath + PhotoName;
			// ��������ļ���Ŀ¼�Ƿ����
			File fileDir = new File(filePath);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			// �����ļ���д����
			fileOut = new FileOutputStream(fileName);
			// �����ļ�������
			fileOut.write(dataBytes);
			fileOut.close();
			OutputStream out = response.getOutputStream();
			out.write("success".getBytes("UTF-8"));
			out.close();
		}
	}
}
