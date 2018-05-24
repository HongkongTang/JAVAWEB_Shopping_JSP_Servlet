package edu.sdut.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

/**
 * 连接数据库初始化
 * @author Vision_TXG
 *
 */
public class UtilDb {
	private static final String USER = "root";//数据库用户名
	private static final String PASSWORD = "root";//数据库密码
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/MyshoppingSystem";//数据库url
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static Connection conn = null; //连接数据库对象
	
	static{
		try {
			Class.forName(DRIVER);//加载驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取connection连接对象
	public static Connection getConnection(){
		//通过单例模式实现
		if(conn==null){
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				return conn;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	//测试连接
	public static void main(String[] args) {
		Connection conn = UtilDb.getConnection();
		if(conn!=null){
			System.out.println("连接数据库成功");
		}else{
			System.out.println("连接失败");
		}
	}
	
}
