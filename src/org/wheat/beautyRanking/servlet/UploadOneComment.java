
package org.wheat.beautyRanking.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.Comment;
import org.wheat.beautyRanking.entity.ConstantValue;
import org.wheat.beautyRanking.loader.JsonStreamToObject;

/**
 * Servlet implementation class UploadOneComment
 */
public class UploadOneComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadOneComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in doget  comment");
		HashMap<String,String> values = new HashMap<String,String>();
		values.put("photoId", request.getParameter("photoId"));
		values.put("userPhoneNumber",request.getParameter("userPhoneNumber"));
		values.put("commentTime", request.getParameter("commentTime"));
		values.put("commentContent", request.getParameter("commentContent"));
		System.out.println(values.toString());
//		MysqlDBHelper helper = MysqlDBHelper.getInstance();
//		int code = helper.insertOneComment(values);
//		if (code ==-1){
//			response.setStatus(500);
//			return;
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Comment comment = (Comment)JsonStreamToObject.jsonStreamToObject(request, Comment.class);
		if(comment==null){
			response.setStatus(ConstantValue.ClientParameterErr);
			return;
		}
		MysqlDBHelper dbHelper = MysqlDBHelper.getInstance();
		int code =dbHelper.uploadOneComment(comment);
		response.setStatus(code);
		return;
	}

}
