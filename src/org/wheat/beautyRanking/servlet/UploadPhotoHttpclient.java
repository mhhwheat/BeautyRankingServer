package org.wheat.beautyRanking.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hogachen
 * Servlet implementation class UploadPhoto
 * @deprecated �ϴ�һ��ͼƬ��ĳ��beauty��
 */
public class UploadPhotoHttpclient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPhotoHttpclient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @deprecated�ͻ��˽�����תΪhttps
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

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
