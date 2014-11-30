package org.wheat.beautyRanking.dbHelper;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlDatabase implements BaseDataBase
{
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://192.168.202.197:3306/beauty_ranking?characterEncoding=utf8";
	private String user="root";
	private String password="";
	private Connection conn;
	@Override
	public Connection getConnetion() 
	{
		try
		{
			Class.forName(driver);
			conn=(Connection)DriverManager.getConnection(url, user, password);
			if(!conn.isClosed())
			{
				System.out.println("Succeeded connecting to the Database!");
			}
			else
			{
				System.out.println("Failed connecting to the Database!");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return conn;
	}

}
