package domain;

import java.io.Serializable;
import java.util.Date;
/**
 * @author xudun
 * 用户实体类
 */
public class User implements Serializable {

    private static final long serialVersionUID = -4313782718477229465L;
    
    // 用户ID
    private int userID;
    // 用户名
    private String name;
    // 
    private String sex;
    // 用户邮箱
    
    // 用户生日
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