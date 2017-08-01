package com.sam.entity;

public class User {
	private int id;
	private String username;
	private String phnnumber;
	private String gender;
	private String city;
	private String country;
	
	public User() {

	}

	public User(String username,
			String phnnumber, String gender, String city, String country) {
		super();
		this.username = username;
		this.phnnumber = phnnumber;
		this.gender = gender;
		this.city = city;
		this.country = country;
	}

	public User(int id,String username,
			String phnnumber, String gender, String city, String country) {
		super();
		this.id = id;
		this.username = username;
		this.phnnumber = phnnumber;
		this.gender = gender;
		this.city = city;
		this.country = country;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhnnumber() {
		return phnnumber;
	}

	public void setPhnnumber(String phnnumber) {
		this.phnnumber = phnnumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
