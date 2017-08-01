package com.sam.entity;

public class Product {

	private int pid;
	private int sid;
	private String pname;
	private int cost;
	private String pdescription;

	public Product() {

	}

	public Product(String pname, String pdescription, int cost, int sid) {
		super();
		this.sid = sid;
		this.pname = pname;
		this.cost = cost;
		this.pdescription = pdescription;
	}

	public Product(int id, String pname, String pdescription, int cost, int sid) {
		super();
		this.pid = id;
		this.sid = sid;
		this.pname = pname;
		this.cost = cost;
		this.pdescription = pdescription;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
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
		Product other = (Product) obj;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		return true;
	}

}
