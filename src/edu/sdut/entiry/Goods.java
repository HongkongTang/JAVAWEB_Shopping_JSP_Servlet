package edu.sdut.entiry;

/**
 * ��Ʒ��
 * @author Vision_TXG
 *
 */
public class Goods {
	private int sid;//��Ʒid
	private String sname;//��Ʒ��
	private double sprice;//��Ʒ�۸�
	private String scity;//��Ʒ����
	private int snumber;//��Ʒ����
	private String spicture;//��ƷͼƬ
	
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
