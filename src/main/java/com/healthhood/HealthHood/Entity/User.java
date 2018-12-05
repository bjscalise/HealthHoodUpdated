package com.healthhood.HealthHood.Entity;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="userdetails")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	private String email;
	
//	@OneToMany(mappedBy = "addressid")
	private ArrayList<Address> savedsearches;
	
	public User() {
	}

	public User(Integer userid, String email, ArrayList<Address> savedsearches) {
		super();
		this.userid = userid;
		this.email = email;
		this.savedsearches = savedsearches;
	}
	
	public User(String email, ArrayList<Address> savedsearches) {
		super();
		
		this.email = email;
		this.savedsearches = savedsearches;
	}
	
	

	public User(String email) {
		super();
		this.email = email;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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