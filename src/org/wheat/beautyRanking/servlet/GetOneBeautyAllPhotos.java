package org.wheat.beautyRanking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.json.BeautyIntroductionListJson;
import org.wheat.beautyRanking.entity.json.PhotoListJson;
import org.wheat.beautyRanking.loader.HttpDataLoaderServer;

/**
 * @author hogachen
 * @deprecated 获取某个beauty下所有图片信息的地址
 * Servlet implementation class GetOneBeautyAllPhotos
 */
public class GetOneBeautyAllPhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneBeautyAllPhotos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String beautyId=request.getParameter("beautyId");
		if(beautyId==null)
			return;
		MysqlDBHelper dbHelper=MysqlDBHelper.getInstance();
		PhotoListJson photoListJson=dbHelper.getPhotoList(Integer.parseInt(beautyId));
		if(photoListJson==null)
		{
			System.out.println("photoListJson is null");
			return;
		}
		String json=HttpDataLoaderServer.toJson(photoListJson);
		if(json==null){response.setStatus(500);return;}//服务器错误
		String result=new String(json.getBytes("UTF-8"),"8859_1");
		PrintWriter out=response.getWriter();
		out.print(result);
		out.flush();
		out.close();
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
