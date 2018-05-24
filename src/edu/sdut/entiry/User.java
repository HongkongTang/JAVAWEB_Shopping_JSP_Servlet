package edu.sdut.entiry;

/**
 * 用户类
 * @author Vision_TXG
 *
 */
public class User {
	private int uid;//用户id
	private String username;//用户名
	private String password;//用户密码
	private String goods;//购物车商品的id
	
	//无参构造方法
	public User(){
		
	}
	
	//有参构造方法
	public User(int uid, String uname, String password, String goods) {
		super();
		this.uid = uid;
		this.username = uname;
		this.password = password;
		this.goods = goods;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return username;
	}

	public void setUname(String uname) {
		this.username = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + username + ", password="
				+ password + ", goods=" + goods + "]";
	}
	
}
