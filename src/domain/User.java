package domain;

import java.io.Serializable;
import java.util.Date;
/**
 * @author xudun
 * �û�ʵ����
 */
public class User implements Serializable {

    private static final long serialVersionUID = -4313782718477229465L;
    
    // �û�ID
    private int userID;
    // �û���
    private String name;
    // 
    private String sex;
    // �û�����
    
    // �û�����
    private Date birthday;

    private String password;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}