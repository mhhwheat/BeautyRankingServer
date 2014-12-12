package org.wheat.beautyRanking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wheat.beautyRanking.dbHelper.MysqlDBHelper;
import org.wheat.beautyRanking.entity.BeautyDetail;
import org.wheat.beautyRanking.entity.ConstantValue;
import org.wheat.beautyRanking.entity.json.BeautyDetailJson;
import org.wheat.beautyRanking.loader.HttpDataLoaderServer;

/**
 * 
* @ClassName: GetBeautyDetail 
* @Description: TODO ���������ĳ��beautyʱ����ʾ��beauty����ϸ��Ϣ
* @author hogachen
* @date 2014��12��12�� ����3:46:52 
*
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
	 * @description ������������ݿⲻ�ܻ�ȡ�����ݣ�����500�������
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int beautyId = Integer.parseInt(request.getParameter("beautyId"));
		MysqlDBHelper helper = MysqlDBHelper.getInstance();
		BeautyDetail beautyDetail = helper.getBeautyDetail(beautyId);
		if(beautyDetail==null){
			response.setStatus(ConstantValue.getDataFailed);
			return;
		}
		
		String json=HttpDataLoaderServer.toJson(beautyDetail);
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
