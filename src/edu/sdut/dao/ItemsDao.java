package edu.sdut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import edu.sdut.entiry.Goods;
import edu.sdut.util.UtilDb;

/**
 * �����ݿ��л�ȡ��Ʒ����Ϣ
 * @author Vision_TXG
 *
 */
public class ItemsDao {
	
	//���������Ʒ��Ϣ
	public ArrayList<Goods> getAllGoods(){
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goods";//�õ�������Ʒ��Ϣ��sql���
		
		try {
			conn = UtilDb.getConnection();//��������
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Goods goods = new Goods();
				goods.setSid(rs.getInt("sid"));
				goods.setScity(rs.getString("scity"));
				goods.setSname(rs.getString("sname"));
				goods.setSprice(rs.getDouble("sprice"));
				goods.setSnumber(rs.getInt("snumber"));
				goods.setSpicture(rs.getString("spicture"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//�ͷ���Դ
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return null;
	}
	
	//ͨ����Ʒid��ȡ��Ʒ��Ϣ
	public Goods getGoodsById(int id){
		Goods goods = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String sql = "select * from goods where sid=?";//�õ���Ʒ��Ϣ��sql���
			conn = UtilDb.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				goods = new Goods();
				goods.setSid(rs.getInt("sid"));
				goods.setScity(rs.getString("scity"));
				goods.setSname(rs.getString("sname"));
				goods.setSprice(rs.getDouble("sprice"));
				goods.setSnumber(rs.getInt("snumber"));
				goods.setSpicture(rs.getString("spicture"));
				return goods;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{//�ͷ���Դ
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		ItemsDao id = new ItemsDao();
		Goods goods = id.getGoodsById(1);
		System.out.println(goods.toString());
	}
}
