package com.healthhood.HealthHood.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "savedseaches")
public class SavedSearch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressid;
	private String address;
	private Integer h2i;
	
	@ManyToOne
    @JoinColumn(name="userid", insertable = false, updatable = false)
	private Integer userid;

	public SavedSearch(Integer addressid, String address, Integer h2i, Integer userid) {
		super();
		this.addressid = addressid;
		this.address = address;
		this.h2i = h2i;
		this.userid = userid;
	}
	
	public SavedSearch(String address, Integer h2i, Integer userid) {
		super();
		this.address = address;
		this.h2i = h2i;
		this.userid = userid;
	}

	public SavedSearch() {
	}

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getH2i() {
		return h2i;
	}

	public void setH2i(Integer h2i) {
		this.h2i = h2i;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "SavedSearch [addressid=" + addressid + ", address=" + address + ", h2i=" + h2i + ", userid=" + userid
				+ "]";
	}

}