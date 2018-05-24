package edu.sdut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.sdut.entiry.User;
import edu.sdut.util.UtilDb;

/**
 * �����ݿ��л�ȡ�û�����Ϣ
 * @author Vision_TXG
 *
 */
public class UserDao {

	public ArrayList<User> getAllUser(){
		ArrayList<User> userList = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "select * from user";
			conn =UtilDb.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				User user= new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGoods(rs.getString("goods"));
				userList.add(user);
			}
			return userList;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * �޸��û���Ϣ
	 */
	public static void  ChangeGoods(int id,String goods){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "update user set goods=? where uid=?";
			conn =UtilDb.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, goods);
			ps.setInt(2, id);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
