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
             //��ȡdb.properties�ļ��е����ݿ�������Ϣ
             InputStream in = DbUtils.class.getClassLoader().getResourceAsStream("db.properties");
             Properties prop = new Properties();
             prop.load(in);
             
             //��ȡ���ݿ���������
           // driver = prop.getProperty("driver");
             //��ȡ���ݿ�����URL��ַ
             url = prop.getProperty("url");
             //��ȡ���ݿ������û���
             username = prop.getProperty("username");
             //��ȡ���ݿ���������
             
             //�������ݿ�����
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
    	                  //�رմ洢��ѯ�����ResultSet����
    	                  rs.close();
    	            }catch (Exception e) {
    	                 e.printStackTrace();
    	              }
    	              rs = null;
    	          }
    	         if(st!=null){
    	              try{
    	                  //�رո���ִ��SQL�����Statement����
    	                  st.close();
    	              }catch (Exception e) {
    	                  e.printStackTrace();
    	              }
    	          }
    	          
    	         if(conn!=null){
    	              try{
    	                  //�ر�Connection���ݿ����Ӷ���
    	                  conn.close();
    	              }catch (Exception e) {
    	                 e.printStackTrace();
    	             }
    	          }
    	      }
    	  
     
}