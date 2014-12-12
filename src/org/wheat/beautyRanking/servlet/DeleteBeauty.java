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
import org.wheat.beautyRanking.loader.HttpDataLoaderServer;

/**
 * @deprecated 创建者可以删除自己创建的beauty，当点赞数超过某个值不可以删除
 * Servlet implementation class DeleteBeauty
 */
public class DeleteBeauty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBeauty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String beautyId = request.getParameter("beautyId");
		if(beautyId==null)
		{
			response.setStatus(ConstantValue.ClientParameterErr);
			return ;
		}
		MysqlDBHelper dbHelper=MysqlDBHelper.getInstance();
		int code = -1;
		code = dbHelper.deleteBeauty(beautyId);
		System.out.println(code);
		response.setStatus(code);
		return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
