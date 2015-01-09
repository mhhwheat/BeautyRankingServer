package org.wheat.beautyRanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.BeautyDetail;
import org.wheat.beautyRanking.entity.ConstantValue;
import org.wheat.beautyRanking.loader.JsonStreamToObject;

/**
 * @author hogachen
 * @deprecated �ڳɹ��ϴ�����ͼ��ԭͼ֮���ϴ�һ��beauty��������Ϣ 
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
		oneBeauty.setPrivilege(Integer.parseInt(request.getParameter("privilege")));
		oneBeauty.setTrueName(request.getParameter("beautyName"));
		oneBeauty.setSchool(request.getParameter("school"));
		oneBeauty.setAvatarPath(request.getParameter("avatarPath"));
		oneBeauty.setDescription(request.getParameter("description"));
		oneBeauty.setUserPhoneNumber(request.getParameter("userPhoneNumber"));
		oneBeauty.setPraiseTimes(Integer.parseInt(request.getParameter("praseTimes")));
		oneBeauty.setAdmissionYear(request.getParameter("admissionYear"));
		oneBeauty.setBirthday(request.getParameter("birthday"));
		oneBeauty.setConstellation(request.getParameter("constellation"));
		oneBeauty.setLat(Double.parseDouble(request.getParameter("lat")));
		oneBeauty.setLng(Double.parseDouble(request.getParameter("lng")));
		oneBeauty.setLocationText(request.getParameter("locationText"));
		MysqlDBHelper dbHelper = MysqlDBHelper.getInstance();
		int code =dbHelper.uploadNewBeauty(oneBeauty);
		response.setStatus(code);
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BeautyDetail oneBeauty = (BeautyDetail)JsonStreamToObject.jsonStreamToObject(request, BeautyDetail.class);
		if(oneBeauty==null){
			response.setStatus(ConstantValue.ClientParameterErr);
			return;
		}
		MysqlDBHelper dbHelper = MysqlDBHelper.getInstance();
		int code =dbHelper.uploadNewBeauty(oneBeauty);
		response.setStatus(code);
		return;

	}
}
