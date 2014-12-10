package org.wheat.beautyRanking.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.coders.Coder_Md5;
import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.UserLogin;
import org.wheat.beautyRanking.entity.json.BeautyIntroductionListJson;
import org.wheat.beautyRanking.entity.json.UserLoginJson;
import org.wheat.beautyRanking.loader.HttpDataLoaderServer;

/**
 * Servlet implementation class GetNeighour
 */
public class GetNeighour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNeighour() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 直接用getparameters获取用户userphonenumber，之后进行解密
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		MysqlDBHelper helper=MysqlDBHelper.getInstance();
		System.out.println("lat---------->"+lat+"  "+lng);
		BeautyIntroductionListJson beautyIntroductionListJson=helper.getNeighbour(lat,lng);
		if(beautyIntroductionListJson==null)
		{
			System.out.println("beautyIntroductionListJson is null");
			return;
		}
		String json=HttpDataLoaderServer.toJson(beautyIntroductionListJson);
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
