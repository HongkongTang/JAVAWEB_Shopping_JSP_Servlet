package edu.sdut.entiry;

/**
 * �û���
 * @author Vision_TXG
 *
 */
public class User {
	private int uid;//�û�id
	private String username;//�û���
	private String password;//�û�����
	private String goods;//���ﳵ��Ʒ��id
	
	//�޲ι��췽��
	public User(){
		
	}
	
	//�вι��췽��
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
