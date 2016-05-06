package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import jdbcUtil.DbUtils;
import domain.User;


public class IUserDao {

	/*****************登录校验用户名和密码**************************/
	public static boolean find(String name,String password) throws Exception {
		
		  Connection conn = null;
		  PreparedStatement st = null;
		         ResultSet rs =null;
		       
		            conn = DbUtils.getConn();
		            String sql = "select * from User where name =? and password=?";
		            st = conn.prepareStatement(sql);
		            System.out.println(sql);
		            st.setString(1, name);
		            st.setString(2, password);
		            rs = st.executeQuery();
		   
		  
		          System.out.println(rs);
		if(rs.next()){
			System.out.println("登录成功");
			DbUtils.release(conn, st, rs);
			return true;
		
		}
		else{
			System.out.println("没有记录");
			DbUtils.release(conn, st, rs);
			return false;
			
		}
	}
	/*********检测用户是否存在************/
	public static boolean exist(String name) throws Exception {
		
		  Connection conn = null;
		  PreparedStatement st = null;
		         ResultSet rs =null;
		       
		            conn = DbUtils.getConn();
		            String sql = "select * from User where name =?";
		            st = conn.prepareStatement(sql);
		            st.setString(1, name);
		            rs = st.executeQuery();
		   
		  
		          System.out.println(rs);
		if(rs.next()){
			System.out.println("用户存在");
			DbUtils.release(conn, st, rs);
			return true;
			
		}
		else{
			System.out.println("没有记录");
			DbUtils.release(conn, st, rs);
			return false;
			
		}

		
	}
	/**************************多条件查询
	 * @return ***************/
	public static void query(String id,String name,String password,String birthday) throws Exception{
		 List<Map> lists = new ArrayList<Map>();//存放map的list

		  Connection conn = null;
		  PreparedStatement st = null;
		  ResultSet rs =null;
		  conn = DbUtils.getConn();
		  StringBuffer sb=new StringBuffer();
		  sb.append("select * from user t where 1=1");
		  if(id!="" ){
			    sb.append(  "  and t.id='"+id+"'  "  );
			}
		  if(name!="" ){
			    sb.append(  "  and t.name='"+name+"'  "  );
			}
		  if(password!="" ){
			    sb.append(  "  and t.password='"+password+"'  "  );
			}
		  if(birthday!="" ){
			    sb.append(  "  and t.birthday='"+birthday+"'  "  );
			}
		  String sql=sb.toString();
		  System.out.println(sql);
		  
		  st = conn.prepareStatement(sql);
          rs = st.executeQuery();
  		while(rs.next()){
			Map map = new HashMap();//存放数据的map,放在循环外面就不行，只能取出一条数据
  		  map.put("ID", rs.getString("userID"));
          map.put("NAME", rs.getString("name"));
          map.put("PASSWORD",rs.getString("password"));
          map.put("BIRTHDAY",rs.getString("birthday"));
          lists.add(map);
          
			
  		}
  		JSONArray jsonArray = JSONArray.fromObject(lists);
  	    System.out.println(jsonArray);
  	    
  		DbUtils.release(conn, st, rs);
	
	}
	
	
	/************用于用户的注册***********/
	public static void insert(String name,String password) throws Exception{
		
		  Connection conn = null;
		  PreparedStatement st = null;
		  ResultSet rs =null;
		  conn = DbUtils.getConn();
		String sql="insert into `User` (name,password) values(?,?)";

        st = conn.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, password);
		System.out.println(sql);
     //   rs = st.executeQuery();
        int num = st.executeUpdate();
                    if(num>0){
                     System.out.println("插入成功！！");
             }

		
                   DbUtils.release(conn, st, rs);
	}
	
	

	public static void main(String args[]) {
		
		try {
			//IUserDao.find("admin","12d3456");
			IUserDao.query("","","xudun88","");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
}
