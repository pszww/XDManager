package jdbcUtil;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtils {

     private static String driver = null;
     private static String url = null;
     private static String username = null;
     private static String password = null;
     
     static{
         try{
             //读取db.properties文件中的数据库连接信息
             InputStream in = DbUtils.class.getClassLoader().getResourceAsStream("db.properties");
             Properties prop = new Properties();
             prop.load(in);
             
             //获取数据库连接驱动
           // driver = prop.getProperty("driver");
             //获取数据库连接URL地址
             url = prop.getProperty("url");
             //获取数据库连接用户名
             username = prop.getProperty("username");
             //获取数据库连接密码
             
             //加载数据库驱动
             Class.forName("com.mysql.jdbc.Driver");
         }catch (Exception e) {
             throw new ExceptionInInitializerError(e);
     }
     	}
     
     public static Connection getConn() throws Exception{
    	 return DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","");
    	 //return DriverManager.getConnection(url,username,password);
     }
     
     
         public static void release(Connection conn,Statement st,ResultSet rs){
    	          if(rs!=null){
    	              try{
    	                  //关闭存储查询结果的ResultSet对象
    	                  rs.close();
    	            }catch (Exception e) {
    	                 e.printStackTrace();
    	              }
    	              rs = null;
    	          }
    	         if(st!=null){
    	              try{
    	                  //关闭负责执行SQL命令的Statement对象
    	                  st.close();
    	              }catch (Exception e) {
    	                  e.printStackTrace();
    	              }
    	          }
    	          
    	         if(conn!=null){
    	              try{
    	                  //关闭Connection数据库连接对象
    	                  conn.close();
    	              }catch (Exception e) {
    	                 e.printStackTrace();
    	             }
    	          }
    	      }
    	  
     
}