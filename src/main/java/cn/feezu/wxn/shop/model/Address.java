package cn.feezu.wxn.shop.model;

public class Address {
	private int id;
	private String name;
	private String phone;
	private String postcode;
	private String receiver;
	
	private User user;
	
	
	public String getReceiveUser() {
		return receiver;
	}
	public void setReceiveUser(String receiver) {
		this.receiver = receiver;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
