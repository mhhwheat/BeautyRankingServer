package org.wheat.beautyRanking.dbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.wheat.beautyRanking.entity.BeautyDetail;
import org.wheat.beautyRanking.entity.BeautyIntroduction;
import org.wheat.beautyRanking.entity.BeautyIntroductionList;
import org.wheat.beautyRanking.entity.Comment;
import org.wheat.beautyRanking.entity.ConstantValue;
import org.wheat.beautyRanking.entity.Photo;
import org.wheat.beautyRanking.entity.PhotoList;
import org.wheat.beautyRanking.entity.Praise;
import org.wheat.beautyRanking.entity.RequestRegisterUser;
import org.wheat.beautyRanking.entity.UserLogin;
import org.wheat.beautyRanking.entity.json.BeautyDetailJson;
import org.wheat.beautyRanking.entity.json.BeautyIntroductionListJson;
import org.wheat.beautyRanking.entity.json.PhotoListJson;
import org.wheat.beautyRanking.loader.DateFormatTools;


public class MysqlDBHelper
{
	private static MysqlDBHelper dbHelper=new MysqlDBHelper();
//	private MysqlDatabase database=new MysqlDatabase();
	private MysqlDBHelper(){};
	public static MysqlDBHelper getInstance()
	{
		return dbHelper;
	}

	public static void CloseConnAndStatement(Connection conn,
			PreparedStatement ps,ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			ConnectionPool.getInstance().returnConnection(conn);
		}
		
	}
	public UserLogin selectUser(String userPhoneNumber)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserLogin user=new UserLogin();
		try{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="select * from user_table where user_phone_number="+userPhoneNumber;
			ps=conn.prepareStatement(querySql);
			rs=ps.executeQuery(querySql);
			if(rs.next())
			{
				user.setUserPhoneNumber(rs.getString("user_phone_number"));
				user.setPassword(rs.getString("password"));
				user.setNikeName(rs.getString("nikename"));
				user.setSchool(rs.getString("school"));
				user.setAdmissionYear(rs.getInt("admission_year"));
				user.setSex(rs.getString("sex"));
			}
			else
				return null;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CloseConnAndStatement(conn,ps,rs);
		}
		return user;
	}
	public boolean insertUser(HashMap<String, String> user)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String insql="insert into user_table(user_phone_number,password,nikename,school,admission_year,sex) values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(insql);
			ps.setString(1, user.get("userPhoneNumber"));
			ps.setString(2, user.get("password"));
			ps.setString(3, user.get("nikeName"));
			ps.setString(4, user.get("school"));
			ps.setInt(5, Integer.parseInt(user.get("admissionYear")));
			ps.setString(6, user.get("sex"));
			int resutl=ps.executeUpdate();
			if(resutl>0)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			CloseConnAndStatement(conn,ps,null);
		}
		return false;
	}
	public boolean insertUserTable(RequestRegisterUser user)
	{
		Connection conn=null;
		java.sql.PreparedStatement ps=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String insql="insert into user_table(user_phone_number,password,nikename,school,admission_year,sex,avatar_path) values(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(insql);
			ps.setString(1, user.getUserPhoneNumber());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNickName());
			ps.setString(4, user.getSchool());
			ps.setInt(5, user.getAdmissionYear());
			ps.setString(6, user.getSex());
			ps.setString(7, user.getAvatarPath());
			int resutl=ps.executeUpdate();
			if(resutl>0)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			CloseConnAndStatement(conn,ps,null);
		}
		return false;
	}
	/*
	public boolean insertPhoto(Photo_huahua photo)
	{
		Connection conn=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String insql="insert into photo(photo_id,beauty_id,photo_path,user_phone_number,upload_time) values(?,?,?,?,?)";
			java.sql.PreparedStatement ps=conn.prepareStatement(insql);
			ps.setInt(1, photo.getPhotoID());
			ps.setInt(2, photo.getBeautyID());
			ps.setString(3, photo.getPhotoPath());
			ps.setString(4, photo.getUserPhoneNumber());
			ps.setString(5, photo.getUploadTime());
			int resutl=ps.executeUpdate();
			if(resutl>0)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean insertCommentRecord(Comment comment)
	{
		Connection conn=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String insql="insert into comment_record(photo_id,beauty_id,user_phone_number,comment_time,comment_content) values(?,?,?,?,?)";
			java.sql.PreparedStatement ps=conn.prepareStatement(insql);
			ps.setInt(1, comment.getPhotoID());
			ps.setInt(2, comment.getBeautyID());
			ps.setString(3, comment.getUserPhoneNumber());
			ps.setDate(4, DateFormatTools.utilDate2SqlDate(comment.getCommentTime()));
			ps.setString(5, comment.getCommentContent());
			int resutl=ps.executeUpdate();
			if(resutl>0)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean insertPraiseRecord(PraiseRecord praiseRecord)
	{
		Connection conn=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String insql="insert into praise_record(user_phone_number,beauty_id,praise_time) values(?,?,?)";
			java.sql.PreparedStatement ps=conn.prepareStatement(insql);
			ps.setString(1, praiseRecord.getUserPhoneNumber());
			ps.setInt(2, praiseRecord.getBeauty());
			ps.setDate(3, DateFormatTools.utilDate2SqlDate(praiseRecord.getPraiseTime()));
			int resutl=ps.executeUpdate();
			if(resutl>0)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}*/
	//返回值0代表用户名不存在，1表示密码不正确，2表示用户名和密码都正确
	public int isUserExist(String userPhoneNumber,String userPassword)
	{
		Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		int returnCode=0;
		try{
			conn = ConnectionPool.getInstance().getConnection();
			String sql="selct * from user_table where user_phone_number='"+userPhoneNumber+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
			if(rs.next())
			{
				if(userPassword.equals(rs.getString("password")))
					returnCode=2;
				else 
					returnCode=1;
			}
			else
				returnCode=0;
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			CloseConnAndStatement(conn,ps,rs);
		}
		return returnCode;
	}
	
	/**
	 * 查找新人榜的榜单
	 * @param firstIndex 起始记录
	 * @param count 需要查询记录的数目
	 * @return
	 */
	public BeautyIntroductionListJson getNewPage(int firstIndex,int count)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<BeautyIntroduction> list=new ArrayList<BeautyIntroduction>();
		BeautyIntroductionList beautyList;
		BeautyIntroductionListJson beautyIntroductionListJson=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="select beauty_id , true_name, school , description ,avatar_path from beauty order by create_time desc limit ?,?";
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, firstIndex);
			ps.setInt(2, count);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BeautyIntroduction temp=new BeautyIntroduction();
				temp.setBeautyName(rs.getString("true_name"));
				temp.setSchool(rs.getString("school"));
				temp.setDescription(rs.getString("description"));
				temp.setAvatarPath(rs.getString("avatar_path"));
				list.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CloseConnAndStatement(conn,ps, rs);
		}
		if(list.size()>0)
		{
			beautyList=new BeautyIntroductionList();
			beautyList.setIntroductionList(list);
			beautyIntroductionListJson=new BeautyIntroductionListJson();
			beautyIntroductionListJson.setData(beautyList);
		}
		return beautyIntroductionListJson;
	}
	
	/**
	 * 查找提升榜的榜单
	 * @param firstIndex
	 * @param count
	 * @param before 前before天的上升数据
	 * @return
	 */
	public BeautyIntroductionListJson getRisePage(int firstIndex,int count,int before)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<BeautyIntroduction> list=new ArrayList<BeautyIntroduction>();
		BeautyIntroductionList beautyList;
		BeautyIntroductionListJson beautyIntroductionListJson=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="select beauty_id , true_name , school , description , avatar_path "
					+ "from beauty where beauty_id in ( select beauty_id from "
					+ " (select beauty_id ,count(*) as count_for_weeks from praise_record where praise_time > ? "
					+ "group by beauty_id order by count_for_weeks desc limit ?,?) as temp)";
			ps=conn.prepareStatement(querySql);
			ps.setString(1, getDateBefore(before));
			ps.setInt(2, firstIndex);
			ps.setInt(3, count);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BeautyIntroduction temp=new BeautyIntroduction();
				System.out.println(rs.getString("true_name"));
				temp.setBeautyName(rs.getString("true_name"));
				temp.setSchool(rs.getString("school"));
				temp.setDescription(rs.getString("description"));
				temp.setAvatarPath(rs.getString("avatar_path"));
				list.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			CloseConnAndStatement(conn,ps, rs);
		}
		if(list.size()>0)
		{
			beautyList=new BeautyIntroductionList();
			beautyList.setIntroductionList(list);
			beautyIntroductionListJson=new BeautyIntroductionListJson();
			beautyIntroductionListJson.setData(beautyList);
		}
		return beautyIntroductionListJson;
	}
	private String getDateBefore(int nums)
	{
		Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -nums);
        return f.format(c.getTime());
	}
	
	/**
	 * 查找总榜的榜单
	 * @param firstIndex
	 * @param count
	 * @return
	 */
	public BeautyIntroductionListJson getSumPage(int firstIndex,int count)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<BeautyIntroduction> list=new ArrayList<BeautyIntroduction>();
		BeautyIntroductionList beautyList;
		BeautyIntroductionListJson beautyIntroductionListJson=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="select beauty_id , true_name ,school, description , avatar_path from beauty order by praise_times desc limit ?,?";
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, firstIndex);
			ps.setInt(2, count);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BeautyIntroduction temp=new BeautyIntroduction();
				temp.setBeautyName(rs.getString("true_name"));
				temp.setSchool(rs.getString("school"));
				temp.setDescription(rs.getString("description"));
				temp.setAvatarPath(rs.getString("avatar_path"));
				list.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			CloseConnAndStatement(conn,ps,rs);
		}
		if(list.size()>0)
		{
			beautyList=new BeautyIntroductionList();
			beautyList.setIntroductionList(list);
			beautyIntroductionListJson=new BeautyIntroductionListJson();
			beautyIntroductionListJson.setData(beautyList);
		}
		return beautyIntroductionListJson;
	}
	
	
	
/*********************************************************************************************/	
	
	/**
	 * 查找每一个beauty下的所有图片信息
	 * @param beaytyId beautyId
	 * @return PhotoListJson 某个beautyId下的所有照片信息，图片返回路径信息
	 */
	public PhotoListJson getPhotoList(int firstIndex,int count,int beaytyId,String userPhoneNumber)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Photo> list=new ArrayList<Photo>();
		PhotoList photoList;
		PhotoListJson photoListJson=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="select beauty_id , photo_id , user_phone_number ,praise_count,"
					+ " comment_count , photo_path ,upload_time ,description from photo where beauty_id=?"
					+ " order by photo_id asc limit ?,?";
			
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, beaytyId);
			ps.setInt(2, firstIndex);
			ps.setInt(3, count);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Photo temp=new Photo();
				temp.setBeautyId(rs.getInt("beauty_id"));
				temp.setPhotoId(rs.getInt("photo_id"));
				temp.setUserPhoneNumber(rs.getString("user_phone_number"));
				temp.setPraiseCount(rs.getInt("praise_count"));
				temp.setCommentCount(rs.getInt("comment_count"));
				temp.setPhotoPath(rs.getString("photo_path"));
				temp.setUploadTime(DateFormatTools.sqlDate2UtilDate(rs.getDate("upload_time")));
				temp.setDescription(rs.getString("description"));
				list.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
			photoListJson=new PhotoListJson();
			photoListJson.setData(null);
			photoListJson.setCode(ConstantValue.DBException);
		}
		finally
		{
			CloseConnAndStatement(conn,ps,rs);
		}
		if(list.size()>0)
		{
			//判断请求该页面的用户是否点过赞
			for(Photo photo:list){
				photo.setIspraise(isPrase(photo.getPhotoId(),userPhoneNumber,conn));
			}
			photoList=new PhotoList();
			photoList.setPhotoList(list);
			photoListJson=new PhotoListJson();
			photoListJson.setData(photoList);
		}
		photoListJson=new PhotoListJson();
		photoListJson.setData(null);
		photoListJson.setCode(ConstantValue.DataNotFoundInDB);
		return photoListJson;
	}
	
	public static boolean isPrase(int photoId,String userPhoneNumber,
			Connection conn ){
		String querySql = "select count(*) from praise_record where user_phone_number = ? and photo_id = ?";
		boolean isPraise=false;
		try {
			
			PreparedStatement ps=conn.prepareStatement(querySql);
			ps.setInt(1, photoId);
			ps.setString(2, userPhoneNumber);
			ResultSet res = ps.executeQuery();
			if(res.next()){
				isPraise=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isPraise;
		
	}
	/**
	 * 查找我的关注页面
	 * @param userPhoneNumber  要查找的用户id
	 * @return
	 */
	public BeautyIntroductionListJson getMyFollow(int firstIndex,int count,String userPhoneNumber)
	{
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<BeautyIntroduction> list=new ArrayList<BeautyIntroduction>();
		BeautyIntroductionList beautyList;
		BeautyIntroductionListJson beautyIntroductionListJson=null;
		
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="select beauty_id,true_name,school ,description,avatar_path "
					+ " from beauty where beauty_id in (select beauty_id  "
					+ "from user_follow where user_phone_number = ?) order by beauty_id asc limit ?,?";
			ps=conn.prepareStatement(querySql);
			ps.setString(1, userPhoneNumber);
			ps.setInt(2, firstIndex);
			ps.setInt(3, count);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BeautyIntroduction temp=new BeautyIntroduction();
				temp.setBeautyName(rs.getString("true_name"));
				temp.setSchool(rs.getString("school"));
				temp.setDescription(rs.getString("description"));
				temp.setAvatarPath(rs.getString("avatar_path"));
				list.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
			beautyIntroductionListJson= new BeautyIntroductionListJson();
			beautyIntroductionListJson.setCode(ConstantValue.DBException);
			return beautyIntroductionListJson;
		}
		finally
		{
			CloseConnAndStatement(conn,ps,rs);
		}
		if(list.size()>0)
		{
			beautyList=new BeautyIntroductionList();
			beautyList.setIntroductionList(list);
			beautyIntroductionListJson=new BeautyIntroductionListJson();
			beautyIntroductionListJson.setData(beautyList);
			beautyIntroductionListJson.setCode(ConstantValue.operateSuccess);
			return beautyIntroductionListJson;
		}
		else{
			beautyIntroductionListJson= new BeautyIntroductionListJson();
			beautyIntroductionListJson.setCode(ConstantValue.DataNotFoundInDB);
			return beautyIntroductionListJson;
		}
	}
	
	/**
	 * 查找我的创建页面
	 * @param userPhoneNumber  要查找的用户id
	 * @return
	 */
	public BeautyIntroductionListJson getMyCreate(int firstIndex,int count,String userPhoneNumber)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<BeautyIntroduction> list=new ArrayList<BeautyIntroduction>();
		BeautyIntroductionList beautyList;
		BeautyIntroductionListJson beautyIntroductionListJson=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="select beauty_id  , true_name ,school, description , avatar_path from beauty where user_phone_number = ?"
					+ " order by beauty_id asc limit ?,?";
			ps=conn.prepareStatement(querySql);
			ps.setString(1, userPhoneNumber);
			ps.setInt(2, firstIndex);
			ps.setInt(3, count);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BeautyIntroduction temp=new BeautyIntroduction();
				temp.setBeautyId(rs.getInt("beauty_id"));
				temp.setBeautyName(rs.getString("true_name"));
				temp.setSchool(rs.getString("school"));
				temp.setDescription(rs.getString("description"));
				temp.setAvatarPath(rs.getString("avatar_path"));
				list.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
			beautyIntroductionListJson=new BeautyIntroductionListJson();
			beautyIntroductionListJson.setData(null);
			beautyIntroductionListJson.setCode(ConstantValue.DBException);
			return beautyIntroductionListJson;
		}
		finally
		{
			CloseConnAndStatement(conn,ps,rs);
		}
		if(list.size()>0)
		{
			beautyList=new BeautyIntroductionList();
			beautyList.setIntroductionList(list);
			beautyIntroductionListJson=new BeautyIntroductionListJson();
			beautyIntroductionListJson.setData(beautyList);
			return beautyIntroductionListJson;
		}else{
			beautyIntroductionListJson=new BeautyIntroductionListJson();
			beautyIntroductionListJson.setCode(ConstantValue.DataNotFoundInDB);
			return beautyIntroductionListJson;
		}
	}
	
	
	
	
	
	/**
	 * 查找我附近的人  尝试直接用字符串来查询
	 * @param userPhoneNumber  要查找的用户id
	 * @return
	 */
	public BeautyIntroductionListJson getNeighbour(int firstIndex,int count,double lat,double lng){
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<BeautyIntroduction> list=new ArrayList<BeautyIntroduction>();
		BeautyIntroductionList beautyList;
		BeautyIntroductionListJson beautyIntroductionListJson=null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="select * from beauty where  "
					+ "lat > ?-1 and  "
					+ "lat < ?+1 and "
					+ "lng > ?-1 and  "
					+ "lng < ?+1 "
                    +"order by ACOS(SIN((? * 3.1415) / 180 ) *"
                    + "SIN((lat * 3.1415) / 180 ) +"
                    + "COS((? * 3.1415) / 180 ) *"
                    + "COS((lat * 3.1415) / 180 ) *"
                    + "COS((? * 3.1415) / 180 - (lng * 3.1415) / 180 ) ) "
                    + "* 6380 asc limit ?,?";
			ps=conn.prepareStatement(querySql);
			ps.setDouble(1, lat);
			ps.setDouble(2,lat);
			ps.setDouble(3,lng);
			ps.setDouble(4, lng);
			ps.setDouble(5, lat);
			ps.setDouble(6,lat);
			ps.setDouble(7, lng);
			ps.setInt(8, firstIndex);
			ps.setInt(9, count);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BeautyIntroduction temp=new BeautyIntroduction();
				temp.setBeautyName(rs.getString("true_name"));
				temp.setSchool(rs.getString("school"));
				temp.setDescription(rs.getString("description"));
				temp.setAvatarPath(rs.getString("avatar_path"));
				list.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
			BeautyIntroductionListJson errorListJson = new BeautyIntroductionListJson();
			errorListJson.setCode(ConstantValue.DBException);
			System.out.println("after print exception");
			return errorListJson;
		}
		finally
		{
			CloseConnAndStatement(conn,ps,rs);
		}
		if(list.size()>0)
		{
			beautyList=new BeautyIntroductionList();
			beautyList.setIntroductionList(list);
			beautyIntroductionListJson=new BeautyIntroductionListJson();
			beautyIntroductionListJson.setData(beautyList);
			beautyIntroductionListJson.setCode(ConstantValue.operateSuccess);
			return beautyIntroductionListJson;
		}
		BeautyIntroductionListJson errorListJson = new BeautyIntroductionListJson();
		errorListJson.setCode(ConstantValue.DataNotFoundInDB);
		return errorListJson;
	}
	
	
	
	
	/**
	 * 上传某个beauty的照片
	 * @param userPhoneNumber  要查找的用户id
	 * @return int 插入数据库的代码
	 */
	public int uploadBeautyPhoto(Photo photo)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		int  successCount=-1;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="insert into photo (beauty_id ,photo_path,user_phone_number,"
					+ "upload_time,comment_count,praise_count,description) "
					+ "values (?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, photo.getBeautyId());
			ps.setString(2, photo.getPhotoPath());
			ps.setString(3,photo.getUserPhoneNumber());
			//String TO datetime
			ps.setDate(4, DateFormatTools.utilDate2SqlDate(photo.getUploadTime()));//2014-11-01 12:00:00
			ps.setInt(5,photo.getCommentCount());
			ps.setInt(6, photo.getPraiseCount());
			ps.setString(7, photo.getDescription());
			successCount=ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			CloseConnAndStatement(conn,ps,null);
		}
		if(successCount>0){
			System.out.println("success!");
			return ConstantValue.operateSuccess;
		}else{
			System.out.println("faild");
			return ConstantValue.InsertDbFailed;
		}
	}
	
	/**
	 * 创建一个新的beauty插入的第一张图片之后需要获取插入的beautyId
	 * @param userPhoneNumber  要查找的用户id
	 * @return int 插入数据库的代码
	 */
	public static int getBeautyId(String userPhoneNumber,Connection conn)
	{
		int beautyId=-1;
		try
		{
			String querySql="select Max(beauty_id)  from beauty where user_phone_number = ?";
			PreparedStatement ps=conn.prepareStatement(querySql);
			ps.setString(1, userPhoneNumber);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				beautyId = rs.getInt("beauty_id");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return beautyId;
	}
	
	/**
	 * 创建一个全新的beauty专题
	 * @param userPhoneNumber  要查找的用户id
	 * @return int 插入数据库的代码
	 */
	public int uploadNewBeauty(BeautyDetail oneBeauty)
	{
		System.out.println("in uploadnewbeauyt");
		Connection conn=null;
		PreparedStatement ps=null;

		int  insertBeautyCount=-1;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="insert into beauty (avatar_path ,true_name,user_phone_number,"
					+ "praise_times,school,admission_year,birthday,constellation,description,"
					+ "create_time,lat,lng) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(querySql);
			ps.setString(1, oneBeauty.getAvatarPath());
			ps.setString(2, oneBeauty.getTrueName());
			ps.setString(3,oneBeauty.getUserPhoneNumber());//创建者的user_phone_number
			ps.setInt(4, oneBeauty.getPraiseTimes());
			ps.setString(5,oneBeauty.getSchool());
			ps.setString(6,oneBeauty.getAdmissionYear()); 
			
			ps.setString(7, oneBeauty.getBirthday());
			ps.setString(8, oneBeauty.getConstellation());
			ps.setString(9,oneBeauty.getDescription());
			ps.setDate(10, DateFormatTools.utilDate2SqlDate(oneBeauty.getCreateTime()));
			ps.setDouble(11,oneBeauty.getLat());
			ps.setDouble(12, oneBeauty.getLng());
			insertBeautyCount=ps.executeUpdate();

			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			CloseConnAndStatement(conn,ps,null);
			if(conn!=null){
				try {
//					conn.close();
					ConnectionPool.getInstance().returnConnection(conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(insertBeautyCount>0){
			System.out.println("success!");
			return ConstantValue.operateSuccess;//插入成功
		}else{
			System.out.println("faild");
			return ConstantValue.InsertDbFailed;//插入失败
		}
	}
	
	
	
	
	/**
	 * 在插入一条评论之后更新评论次数
	 * @param values 需要插入的数据
	 * @return int 插入数据库的代码
	 */
	public int updateCommentCount(int photoId,Connection conn,PreparedStatement ps)
	{
		int  updateCount=-1;
		try
		{
			String querySql="update photo set comment_count=comment_count+1 where photo_id =?";
			ps.setInt(1, photoId);
			updateCount=ps.executeUpdate();
			

		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(updateCount>0){
			System.out.println("success!");
			return ConstantValue.operateSuccess;//插入成功
		}else{
			System.out.println("faild");
			return ConstantValue.updateCommentCountFailed;//插入失败
		}
	}
	
	/**
	 * 插入一条评论,插入后需要更新photo中的comment_count
	 * @param values 需要插入的数据
	 * @return int 插入数据库的代码
	 */
	public int uploadOneComment(Comment comment)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		int  insertCommentCount=-1;
		int updateCommentCount=-1;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="insert into comment_record (photo_id ,user_phone_number,"
					+ "comment_time,comment_content) "
					+ "values (?,?,?,?)";
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, comment.getPhotoID());
			ps.setString(2, comment.getUserPhoneNumber());
			ps.setDate(3,DateFormatTools.utilDate2SqlDate(comment.getCommentTime()));
			ps.setString(4, comment.getCommentContent());
			
			insertCommentCount=ps.executeUpdate();
			if(insertCommentCount>0)
				updateCommentCount=updateCommentCount(comment.getPhotoID(),conn,ps);
			else
				return ConstantValue.InsertDbFailed;
			

		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			CloseConnAndStatement(conn,ps,null);
		}
		/**
		 * 这里如果插入失败，上面的插入因该重做redo，暂时不考虑
		 */
		if(updateCommentCount>0){
			System.out.println("success!");
			return ConstantValue.operateSuccess;//插入成功
		}else{
			System.out.println("faild");
			return ConstantValue.InsertDbFailed;//插入失败
		}
	}
	
	
	
	/**
	 * 插入一条评论,插入点赞后需要更新photo中的praise_count和beauty下的praist_count
	 * @param values 需要插入的数据
	 * @return int 插入数据库的代码
	 */
	public int uploadPraise(Praise praise)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		int  insertCommentCount=-1;
		int updatePraiseCount=-1;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			String querySql="insert into praise_record (user_phone_number ,praise_time,"
					+ "photo_id) "
					+ "values (?,?,?)";
			ps=conn.prepareStatement(querySql);
			ps.setString(1, praise.getUserPhoneNumber());
			ps.setDate(2, DateFormatTools.utilDate2SqlDate(praise.getPraiseTime()));
			ps.setInt(3,praise.getPhotoId());
			
			insertCommentCount=ps.executeUpdate();
			String updatePraiseCountSql="update photo set praise_count=praise_count+1 where photo_id =?";
			ps.setInt(1, praise.getPhotoId());
			updatePraiseCount=ps.executeUpdate();
			//更新总的praise_count
			String updateBeautyCountSql="update beauty set praise_count=praise_count+1 where beauty_id =?";
			ps.setInt(1, praise.getBeautyId());
			updatePraiseCount=ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			CloseConnAndStatement(conn,ps,null);
		}
		if(insertCommentCount>0&&updatePraiseCount>0){
			System.out.println("success!");
			return 1;//插入成功
		}else{
			System.out.println("faild");
			return 0;//插入失败
		}
	}
	
	/**
	 * 
	* @Description: when you click one beautyIntroduction ,this function 
	* return the detail info of the beauty
	* @author  hogachen   
	* @date    2014年12月12日 下午3:37:39 
	* @version V1.0  
	* @param   beautyId
	* @return
	 */
	public  BeautyDetailJson getBeautyDetail(int beautyId){
		
		Connection conn=null;
		PreparedStatement ps=null;
		BeautyDetail temp =null;
		try
		{
			conn = ConnectionPool.getInstance().getConnection();
			
			String querySql="select beauty_id , avatar_path ,user_phone_number, praise_times ,"
					+ " school ,admission_year,birthday, constellation,description,create_time  "
					+ "from beauty where beauty_id = ?";
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, beautyId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				temp=new BeautyDetail();
				temp.setBeautyId(beautyId);
				temp.setAvatarPath(rs.getString("avatar_path"));
				temp.setUserPhoneNumber(rs.getString("user_phone_number"));
				temp.setPraiseTimes(rs.getInt("praise_times"));
				
				temp.setSchool(rs.getString("school"));
				temp.setAdmissionYear(rs.getString("admission_year"));
				temp.setBirthday(rs.getString("birthday"));
				temp.setConstellation(rs.getString("constellation"));
				temp.setDescription(rs.getString("description"));
				temp.setCreateTime(DateFormatTools.sqlDate2UtilDate(rs.getDate("create_time")));
				System.out.println("in the rs.next  "+temp.getCreateTime());
			}
			
		}catch(Exception e){
			e.printStackTrace();
			BeautyDetailJson beautyJson =new BeautyDetailJson();
			beautyJson.setCode(ConstantValue.DBException);
			return beautyJson;
		}
		finally
		{
			CloseConnAndStatement(conn,ps,null);
		}
		if(temp!=null){
			BeautyDetailJson beautyJson =new BeautyDetailJson();
			beautyJson.setData(temp);
			beautyJson.setCode(ConstantValue.operateSuccess);
			return beautyJson;
		}else{
			BeautyDetailJson beautyJson =new BeautyDetailJson();
			beautyJson.setData(temp);
			beautyJson.setCode(ConstantValue.DataNotFoundInDB);
			beautyJson.setErrMsg("数据库查找不到数据！");
			return beautyJson;
		}
		

		
	}
	/**
	 * @description delete one beauty all message ,including it's photo
	 * @param beautyId
	 * @return the execute code
	 */
	public int deleteBeauty(String beautyId){
		Connection conn = null;
		PreparedStatement ps = null;
		int delBeuCode=-1;
		int delPhoto=1;
		String deleteBeautySql = "delete from beauty where beauty_id = ?";
		try{
			conn = ConnectionPool.getInstance().getConnection();
			ps = conn.prepareStatement(deleteBeautySql);
			ps.setString(1, beautyId);
			delBeuCode = ps.executeUpdate();
			System.out.println("delBeuCode  "+delBeuCode);
			List<String>photoIdList = selectBeautyPhotoId(beautyId);
			int tempCode=-1;
			if(photoIdList!=null)//暂时只要delete  beauty成功就算成功
			for(String photoId : photoIdList){
				tempCode=deletePhoto(photoId);
				if(tempCode<0)delPhoto=-1;
			}			
		}catch (SQLException e){
			e.printStackTrace();
			return ConstantValue.DBException;
		}
		finally
		{
			CloseConnAndStatement(conn,ps,null);
		}
		
		if(delBeuCode >0){//只要删除了beauty就算成功删除了，后面的photo就暂时不管
			if(delPhoto>0)
				return ConstantValue.operateSuccess;
			else
				return ConstantValue.delBeautyButNotPhoto;
		}else
			return ConstantValue.deleRecordNotExist;
	}
	/**
	 * @description when you delete beauty ,you have to delete it's photos
	 * this function select all the photo_id belong to beauty for delete
	 * @param beautyId
	 * @return photo_id belong to beauty for delete
	 */
	public List<String> selectBeautyPhotoId(String beautyId){
		Connection conn = null;
		PreparedStatement ps = null;
		int resultCode=-1;
		List<String>photoIdList = null;
		String sql = "select photo_id  from photo where beauty_id = ? ";
		try{
			conn = ConnectionPool.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, beautyId);
			ResultSet rs = ps.executeQuery();
			photoIdList = new ArrayList<String>();
			while(rs.next()){
				
				String onPhotoId = rs.getString("photo_id");
				photoIdList.add(onPhotoId);
				
			}
		}catch(Exception e){
				e.printStackTrace();
		}
		finally
		{
			CloseConnAndStatement(conn,ps,null);
		}
		
		if(photoIdList.size()>0){
			return photoIdList;
		}else return null;
	}
	/**
	 * @description delete  one photo and it's comments and praises
	 * @param photoId
	 * @return resultCode
	 */
	public int deletePhoto(String photoId){
		Connection conn = null;
		PreparedStatement ps = null;
		int resultCode=-1;
		int delComCode=-1;
		int delPhoCode=-1;
		int delPraCode=-1;
		String deletePhotoSql = "delete from photo where photo_id = ?";
		String deletCommentSql = "delete from comment_record where photo_id = ?";
		String deletePraiseSql = "delete from praise_record where photo_id = ?";
		try{
//			conn = database.getConnetion();
			conn = ConnectionPool.getInstance().getConnection();
			ps = conn.prepareStatement(deletePhotoSql);
			ps.setString(1, photoId);
			delPhoCode = ps.executeUpdate();
			ps = conn.prepareStatement(deletCommentSql);
			ps.setString(1, photoId);
			delComCode = ps.executeUpdate();
			ps = conn.prepareStatement(deletePraiseSql);
			ps.setString(1, photoId);
			delPraCode = ps.executeUpdate();
		}catch (SQLException e){
			
			e.printStackTrace();
			return ConstantValue.DBException;
		}
		finally
		{
			CloseConnAndStatement(conn,ps,null);
		}
		if(delPhoCode >0 ){//自要删除photo就可以了
			return ConstantValue.operateSuccess;
		}
		return ConstantValue.deleRecordNotExist;
	}
	/**
	 * 
	* @Description: TODO 更新特定的beauty项目，其他没有更行的设置为null
	* @author hogachen   
	* @date 2014年12月11日 下午9:37:39 
	* @version V1.0  
	* @param beautyDetail
	* @return
	 */
	public int updataBeautyInfo(BeautyDetail beautyDetail){
		Connection conn = null;
		PreparedStatement ps = null;
		int resultCode=-1;
		try{
//			conn = database.getConnetion();
			conn = ConnectionPool.getInstance().getConnection();
			String sql = "update beauty set "
				     + "true_name=?,"
				     + "user_phone_number=?,"
				     + "school=?,"
				     + "admission_year=?,"
				     + "birthday=?,"
				     + "constellation=?,"
				     + "description=?"
				     + " where beauty_id=?";//注意where前面有个空格
			ps=conn.prepareStatement(sql);
			ps.setString(1, beautyDetail.getTrueName());
			ps.setString(2, beautyDetail.getUserPhoneNumber());
			ps.setString(3, beautyDetail.getSchool());
			ps.setString(4, beautyDetail.getAdmissionYear());
			ps.setInt(5,beautyDetail.getBeautyId());
			ps.setString(6, beautyDetail.getConstellation());
			ps.setString(7, beautyDetail.getDescription()); 
			ps.setInt(8, beautyDetail.getBeautyId());
			resultCode = ps.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
			return ConstantValue.DBException;
		}finally
		{
			CloseConnAndStatement(conn,ps,null);
		}
		if(resultCode >0){
			return ConstantValue.operateSuccess;
		}else{
			return ConstantValue.dataNotInDBCannotUpdate;
		}
	}
	
	
	
	public int deleteComment(int commentId){
		Connection conn = null;
		PreparedStatement ps = null;
		int delComCode=-1;
		String deletePhotoSql = "delete from comment_record where comment_id = ?";
		try{
			conn = ConnectionPool.getInstance().getConnection();
			ps = conn.prepareStatement(deletePhotoSql);
			ps.setInt(1, commentId);
			delComCode = ps.executeUpdate();
		}catch (SQLException e){
			
			e.printStackTrace();
			return ConstantValue.DBException;
		}
		finally
		{
			CloseConnAndStatement(conn,ps,null);
		}
		if(delComCode>0 ){//自要删除photo就可以了
			return ConstantValue.operateSuccess;
		}
		return ConstantValue.deleRecordNotExist;
	}
	
	public int deleteFollow(int beautyId,String userPhoneNumber){
		Connection conn = null;
		PreparedStatement ps = null;
		int delComCode=-1;
		String deletePhotoSql = "delete from user_follow where beauty_id = ? and user_phone_number=?";
		try{
//			conn = database.getConnetion();
			conn = ConnectionPool.getInstance().getConnection();
			ps = conn.prepareStatement(deletePhotoSql);
			ps.setInt(1, beautyId);
			ps.setString(2,userPhoneNumber);
			delComCode = ps.executeUpdate();
		}catch (SQLException e){
			
			e.printStackTrace();
			return ConstantValue.DBException;
		}
		finally
		{
			CloseConnAndStatement(conn,ps,null);
		}
		if(delComCode >0 ){//自要删除photo就可以了
			return ConstantValue.operateSuccess;
		}
		return ConstantValue.deleRecordNotExist;
	}
	
}
