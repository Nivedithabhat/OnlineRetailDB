package com.sam.entity;

public class SubCategory {

	private int sid;
	private int cid;
	private String subcname;
	private String sdescription;

	public SubCategory() {

	}

	public SubCategory(String subcname, String sdescription, int cid) {
		super();
		this.cid = cid;
		this.subcname = subcname;
		this.sdescription = sdescription;
	}

	public SubCategory(int id,String subcname, String sdescription, int cid) {
		super();
		this.sid = id;
		this.cid = cid;
		this.subcname = subcname;
		this.sdescription = sdescription;
	}

	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getSubcname() {
		return subcname;
	}

	public void setSubcname(String subcname) {
		this.subcname = subcname;
	}

	public String getSdescription() {
		return sdescription;
	}

	public void setSdescription(String sdescription) {
		this.sdescription = sdescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((subcname == null) ? 0 : subcname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubCategory other = (SubCategory) obj;
		if (subcname == null) {
			if (other.subcname != null)
				return false;
		} else if (!subcname.equals(other.subcname))
			return false;
		return true;
	}

}