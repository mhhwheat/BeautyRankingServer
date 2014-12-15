package org.wheat.beautyRanking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.ConstantValue;
import org.wheat.beautyRanking.entity.json.BeautyIntroductionListJson;
import org.wheat.beautyRanking.entity.json.PhotoListJson;
import org.wheat.beautyRanking.loader.HttpDataLoaderServer;

/**
 * 
* @ClassName: GetOneBeautyAllPhotos 
* @Description: 获取某个beauty下所有图片信息的地址
* @author hogachen
* @date 2014年12月12日 下午3:22:38 
*
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
		String firstIndex=request.getParameter("firstIndex");
		String count=request.getParameter("count");
		if(firstIndex==null||count==null){
			response.setStatus(ConstantValue.ClientParameterErr);
			return;
		}
		String beautyId=request.getParameter("beautyId");
		System.out.println("in doget "+ beautyId);
		if(beautyId==null)
		{
			response.setStatus(ConstantValue.ClientParameterErr);
			return;
		}
		MysqlDBHelper dbHelper=MysqlDBHelper.getInstance();
		PhotoListJson photoListJson=dbHelper.getPhotoList(Integer.parseInt(firstIndex), Integer.parseInt(count),Integer.parseInt(beautyId));
		String json=HttpDataLoaderServer.toJson(photoListJson);
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
