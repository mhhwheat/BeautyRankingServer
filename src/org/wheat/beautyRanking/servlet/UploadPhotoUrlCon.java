package org.wheat.beautyRanking.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *@author hogachen
 *@description ʹ�� urlConnection�ϴ��ļ�
 */
public class UploadPhotoUrlCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPhotoUrlCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		//�����ܷ񴫲���
		String gid=request.getParameter("gid");
		System.out.println(gid);
		ServletInputStream sis = request.getInputStream();

		File file = new File("D:/BeautyRankingPhoto/recive_photo/1.apk");

		// ������
		byte buffer[] = new byte[1024];
		FileOutputStream fos = new FileOutputStream(file);
		int len = sis.read(buffer, 0, 1024);
		// ���������Ϣѭ�����뵽�ļ���
		System.out.println("start ");
		while (len != -1) {
			fos.write(buffer, 0, len);
			len = sis.readLine(buffer, 0, 1024);
		}
		System.out.println("end ");
		fos.close();
		sis.close();
	}

}
