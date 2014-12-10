package org.wheat.beautyRanking.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.Comment;
import org.wheat.beautyRanking.entity.ConstantValue;
import org.wheat.beautyRanking.entity.json.CommentJson;

import com.google.gson.Gson;

/**
 * Servlet implementation class UploadPraise
 */
public class UploadPraise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPraise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in server dopost");
		HashMap<String,String> values = new HashMap<String,String>();
		values.put("userPhoneNumber", request.getParameter("userPhoneNumber"));
		values.put("praiseTime",request.getParameter("praiseTime"));
		values.put("photoId", request.getParameter("photoId"));
		values.put("beautyId", request.getParameter("beautyId"));
		System.out.println(values.toString());
		MysqlDBHelper helper = MysqlDBHelper.getInstance();
		int code = helper.insertOnePraise(values);
		if (code ==-1){
			response.setStatus(ConstantValue.ServerDataNotGet);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in server dopost");
		HashMap<String,String> values = new HashMap<String,String>();
		values.put("userPhoneNumber", request.getParameter("userPhoneNumber"));
		values.put("praiseTime",request.getParameter("praiseTime"));
		values.put("photoId", request.getParameter("phoneId"));
		values.put("beautyId", request.getParameter("beautyId"));
		System.out.println(values.toString());
//		MysqlDBHelper helper = MysqlDBHelper.getInstance();
//		int code = helper.insertOnePraise(values);
		int code=1;
		if (code ==-1){
			response.setStatus(500);
			return;
		}
	}

}
