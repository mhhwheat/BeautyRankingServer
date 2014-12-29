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
import org.wheat.beautyRanking.entity.json.UserLoginJson;
import org.wheat.beautyRanking.loader.HttpDataLoaderServer;

public class BeautyRankingLogin extends HttpServlet 
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public BeautyRankingLogin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post method---------------->");
		InputStream is=request.getInputStream();
		int streamLength=request.getContentLength();
		byte[] data=new byte[streamLength];
		int count=0;
		int len=0;
		while((len=is.read(data, count, streamLength-count))!=-1)
		{
			count=+len;
		}
		HashMap<String, String> postData=null;
		try {
			postData=HttpDataLoaderServer.dencryptParamsFromPost(data);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if(postData==null)
		{
			//û�յ��ͻ��˷���������
			System.out.println("û���յ��ͻ�������");
		}
		MysqlDBHelper helper=MysqlDBHelper.getInstance();
		System.out.println("userPhoneNumber---------->"+postData.get("userPhoneNumber"));
		UserLogin user=helper.selectUser(postData.get("userPhoneNumber"));
		UserLoginJson userJson=new UserLoginJson();
		if(user==null)
		{
			userJson.setCode(0);//0��ʾ�����ڸ��û�
			userJson.setData(null);
		}
		else
		{   System.out.println("postData.get(password) "+postData.get("password"));
			System.out.println("user.getPassword(): "+user.getPassword());
//			System.out.println("Coder_Md5.md5(postData.get(password))  "
//			+Coder_Md5.md5(postData.get("password")));
			if(postData.get("password").equals(user.getPassword()))
			{
				user.setPassword(null);
				userJson.setData(user);
				userJson.setCode(1);//1��ʾ��¼�ɹ�
			}
			else
			{
				userJson.setCode(-1);//-1��ʾ���벻��ȷ
				userJson.setData(null);
			}
		}
		PrintWriter out=response.getWriter();
		out.print(HttpDataLoaderServer.toJson(userJson));
		out.flush();
		out.close();
		return;
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	

}
