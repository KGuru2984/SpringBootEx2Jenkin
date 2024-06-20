package com.edubridge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="UserInfoCatalog")
public class UserInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userinfoid;
	private String username;
	private String useremail;
	private String userpassword;
	public Integer getUserinfoid() {
		return userinfoid;
	}
	public void setUserinfoid(Integer userinfoid) {
		this.userinfoid = userinfoid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public UserInfo(Integer userinfoid, String username, String useremail, String userpassword) {
		super();
		this.userinfoid = userinfoid;
		this.username = username;
		this.useremail = useremail;
		this.userpassword = userpassword;
	}
	public UserInfo(String username, String useremail, String userpassword) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.userpassword = userpassword;
	}
	public UserInfo() {
		super();
	}
	@Override
	public String toString() {
		return "UserInfo [userinfoid=" + userinfoid + ", username=" + username + ", useremail=" + useremail
				+ ", userpassword=" + userpassword + "]";
	}
	
	
	
	
}
