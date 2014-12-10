package org.wheat.beautyRanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.BeautyDetail;
import org.wheat.beautyRanking.entity.BeautyIntroduction;

/**
 * @author hogachen
 * @deprecated 在成功上传缩略图和原图之后，上传一个beauty的所有信息 
 * Servlet implementation class  UploadBeautyInfo
 */
public class UploadBeautyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadBeautyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BeautyDetail oneBeauty = new BeautyDetail();

		oneBeauty.setTrueName(request.getParameter("beautyName"));
		oneBeauty.setSchool(request.getParameter("school"));
		oneBeauty.setAvatarPath(request.getParameter("avatarPath"));
		oneBeauty.setDescription(request.getParameter("description"));
		oneBeauty.setUserPhoneNumber(request.getParameter("userPhoneNumber"));
		oneBeauty.setPraseTimes(request.getParameter("praseTimes"));
		oneBeauty.setAdmissionYear(request.getParameter("admissionYear"));
		oneBeauty.setBirthday(request.getParameter("birthday"));
		oneBeauty.setConstellation(request.getParameter("constellation"));
//		MysqlDBHelper dbHelper = MysqlDBHelper.getInstance();
//		int code =dbHelper.uploadNewBeauty(oneBeauty);
//		if(code==-1){
//			response.setStatus(500);//服务器错误
//			return;
//		}
		System.out.println(oneBeauty.getAdmissionYear());
		System.out.println(oneBeauty.getSchool());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BeautyDetail oneBeauty = new BeautyDetail();

		oneBeauty.setTrueName(request.getParameter("beautyName"));
		oneBeauty.setSchool(request.getParameter("school"));
		oneBeauty.setAvatarPath(request.getParameter("avatarPath"));
		oneBeauty.setDescription(request.getParameter("description"));
		oneBeauty.setUserPhoneNumber(request.getParameter("userPhoneNumber"));
		oneBeauty.setPraseTimes(request.getParameter("praseTimes"));
		oneBeauty.setAdmissionYear(request.getParameter("admissionYear"));
		oneBeauty.setBirthday(request.getParameter("birthday"));
		oneBeauty.setConstellation(request.getParameter("constellation"));
		MysqlDBHelper dbHelper = MysqlDBHelper.getInstance();
		int code =dbHelper.uploadNewBeauty(oneBeauty);
		if(code==-1){
			response.setStatus(500);//服务器错误
			return;
		}
		
	}
}
