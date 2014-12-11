package org.wheat.beautyRanking.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.BeautyDetail;
import org.wheat.beautyRanking.entity.ConstantValue;
import org.wheat.beautyRanking.entity.Photo;
import org.wheat.beautyRanking.loader.DateFormatTools;
import org.wheat.beautyRanking.loader.JsonStreamToObject;

/**
 * @author hogachen
 * @deprecated 上传某个beauty的一张照片
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

		Photo photo = new Photo();
		photo.setCommentCount(0);
		photo.setPhotoPath(request.getParameter("photoPath"));
		photo.setPraiseCount(0);
		photo.setUploadTime((DateFormatTools.Str2UtilDate(request.getParameter("uploadTime"))));
		photo.setUserPhoneNumber(request.getParameter("userPhoneNumber"));
		photo.setBeautyId(Integer.parseInt(request.getParameter("beautyId")));
		MysqlDBHelper dbHelper = MysqlDBHelper.getInstance();
		dbHelper.uploadBeautyPhoto(photo);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Photo photo = (Photo)JsonStreamToObject.jsonStreamToObject(request, Photo.class);
		if(photo==null){
			response.setStatus(ConstantValue.ClientParameterErr);
			return;
		}
		MysqlDBHelper dbHelper = MysqlDBHelper.getInstance();
		int code =dbHelper.uploadBeautyPhoto(photo);
		response.setStatus(code);
		return;
	}

}
