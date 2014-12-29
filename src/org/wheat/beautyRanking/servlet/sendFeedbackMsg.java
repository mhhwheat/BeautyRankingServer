package org.wheat.beautyRanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.ConstantValue;

/**
 * Servlet implementation class sendFeedbackMsg
 */
public class sendFeedbackMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendFeedbackMsg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String feedbackMsg = request.getParameter("FeedbackMsg");
		String userPhoneNumber = request.getParameter("userPhoneNumber");
		if(feedbackMsg==null)
		{
			response.setStatus(ConstantValue.ClientParameterErr);
			return ;
		}
		MysqlDBHelper dbHelper=MysqlDBHelper.getInstance();
		int code = -1;
		code = dbHelper.insertFeedbackMsg(userPhoneNumber,feedbackMsg);
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
