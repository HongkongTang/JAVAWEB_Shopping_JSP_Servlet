package edu.sdut.entiry;

/**
 * 商品类
 * @author Vision_TXG
 *
 */
public class Goods {
	private int sid;//商品id
	private String sname;//商品名
	private double sprice;//商品价格
	private String scity;//商品产地
	private int snumber;//商品数量
	private String spicture;//商品图片
	
	public Goods(){
		
	}

	public Goods(int sid, String sname, double sprice, String scity,
			int snumber, String spicture) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sprice = sprice;
		this.scity = scity;
		this.snumber = snumber;
		this.spicture = spicture;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public double getSprice() {
		return sprice;
	}

	public void setSprice(double sprice) {
		this.sprice = sprice;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	public int getSnumber() {
		return snumber;
	}

	public void setSnumber(int snumber) {
		this.snumber = snumber;
	}

	public String getSpicture() {
		return spicture;
	}

	public void setSpicture(String spicture) {
		this.spicture = spicture;
	}

	@Override
	public String toString() {
		return "Goods [sid=" + sid + ", sname=" + sname + ", sprice=" + sprice
				+ ", scity=" + scity + ", snumber=" + snumber + ", spicture="
				+ spicture + "]";
	}
	
	
}
