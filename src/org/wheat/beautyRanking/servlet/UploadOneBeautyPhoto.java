package org.wheat.beautyRanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.Photo;

/**
 * @author hogachen
 * @deprecated �ϴ�ĳ��beauty��һ����Ƭ
 * Servlet implementation class UploadOneBeautyPhoto
 */
public class UploadOneBeautyPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadOneBeautyPhoto() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Photo photo = new Photo();
		photo.setCommentCount(0);
		photo.setPhotoPath(request.getParameter("photoPath"));
		photo.setPraiseCount(0);
		photo.setUploadTime(request.getParameter("uploadTime"));
		photo.setUserPhoneNumber(request.getParameter("userPhoneNumber"));
		photo.setBeautyId(request.getParameter("beautyId"));
		MysqlDBHelper dbHelper = MysqlDBHelper.getInstance();
		dbHelper.uploadBeautyPhoto(photo);	
	}

}