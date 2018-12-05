package com.healthhood.HealthHood.Entity;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="userdetails")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	private String email;
	private ArrayList<Address> savedsearches;
	
	public User() {
	}

	public User(Integer userid, String email, ArrayList<Address> savedsearches) {
		super();
		this.userid = userid;
		this.email = email;
		this.savedsearches = savedsearches;
	}
	
	public User(String email, String userpassword, ArrayList<Address> savedsearches) {
		super();
		this.userid = userid;
		this.email = email;
		this.savedsearches = savedsearches;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return email;
	}

	public void setUsername(String email) {
		this.email = email;
	}


	public ArrayList<Address> getSavedsearches() {
		return savedsearches;
	}

	public void setSavedsearches(ArrayList<Address> savedsearches) {
		this.savedsearches = savedsearches;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", email=" + email +  ", savedsearches=" + savedsearches + "]";
	}
	
	
	
}