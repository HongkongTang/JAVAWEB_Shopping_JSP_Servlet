package edu.sdut.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

/**
 * �������ݿ��ʼ��
 * @author Vision_TXG
 *
 */
public class UtilDb {
	private static final String USER = "root";//���ݿ��û���
	private static final String PASSWORD = "root";//���ݿ�����
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/MyshoppingSystem";//���ݿ�url
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static Connection conn = null; //�������ݿ����
	
	static{
		try {
			Class.forName(DRIVER);//��������
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȡconnection���Ӷ���
	public static Connection getConnection(){
		//ͨ������ģʽʵ��
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
	//��������
	public static void main(String[] args) {
		Connection conn = UtilDb.getConnection();
		if(conn!=null){
			System.out.println("�������ݿ�ɹ�");
		}else{
			System.out.println("����ʧ��");
		}
	}
	
}
