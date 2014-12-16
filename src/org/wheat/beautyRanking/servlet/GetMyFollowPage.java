package org.wheat.beautyRanking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.loader.HttpDataLoaderServer;
import org.wheat.beautyRanking.entity.ConstantValue;
import org.wheat.beautyRanking.entity.json.BeautyIntroductionListJson;
/**
 * Servlet implementation class GetMyFollowPage
 */
public class GetMyFollowPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyFollowPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//dencrypt the userphonenumber first
		String firstIndex=request.getParameter("firstIndex");
		String count=request.getParameter("count");
		if(firstIndex==null||count==null){
			response.setStatus(ConstantValue.ClientParameterErr);
			return;
		}
		String userPhoneNumber= request.getParameter("userPhoneNumber");
		MysqlDBHelper dbHelper=MysqlDBHelper.getInstance();
		BeautyIntroductionListJson beautyIntroductionListJson=dbHelper.getMyFollow(Integer.parseInt(firstIndex), Integer.parseInt(count),userPhoneNumber);

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
