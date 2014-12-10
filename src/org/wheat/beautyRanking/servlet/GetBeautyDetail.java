package org.wheat.beautyRanking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.BeautyDetail;
import org.wheat.beautyRanking.entity.json.BeautyDetailJson;
import org.wheat.beautyRanking.loader.HttpDataLoaderServer;

/**
 * @author hogachen
 * @deprecated 当点击进入某个beauty时，显示该beauty的详细信息
 * Servlet implementation class GetBeautyDetail
 */
public class GetBeautyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBeautyDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @deprecated 如果服务器数据库不能获取到数据，返回500错误代码
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String beautyId = request.getParameter("beautyId");
		MysqlDBHelper helper = MysqlDBHelper.getInstance();
		BeautyDetail beautyDetail = helper.getBeautyDetail(beautyId);
		if(beautyDetail==null){
			response.setStatus(500);
			return;
		}
		BeautyDetailJson beautyDetailJson = new BeautyDetailJson();
		beautyDetailJson.setData(beautyDetail);
		String json=HttpDataLoaderServer.toJson(beautyDetailJson);
		String responseData= new String(json.getBytes("UTF-8"),"8859_1");
		PrintWriter out = response.getWriter();
		out.print(responseData);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
