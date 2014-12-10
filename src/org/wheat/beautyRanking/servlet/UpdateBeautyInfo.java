package org.wheat.beautyRanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.BeautyDetail;
import org.wheat.beautyRanking.entity.ConstantValue;

/**
 * @deprecated 任何人都可以 更新某个beauty下的信息？？
 * Servlet implementation class UpdateBeautyInfo
 */
public class UpdateBeautyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBeautyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		BeautyDetail beautyDetail = new BeautyDetail();
		
		beautyDetail.setTrueName(request.getParameter("true_name"));
		beautyDetail.setUserPhoneNumber(request.getParameter("userPhoenNumber"));
		beautyDetail.setSchool(request.getParameter("school"));
		beautyDetail.setAdmissionYear(request.getParameter("admissionYear"));
		beautyDetail.setBirthday(request.getParameter("birthday"));
		beautyDetail.setConstellation(request.getParameter("constellation"));
		beautyDetail.setDescription(request.getParameter("description"));

		MysqlDBHelper dbHelper=MysqlDBHelper.getInstance();
		int code = -1;
		code = dbHelper.updataBeautyInfo( beautyDetail);
		if(code == -1){
			response.sendError(ConstantValue.ServerDataNotGet);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
