package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlConnecter {

	private Connection conn = null;
	
	private Connection getConnection() {// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/students?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 增/删/改
	 * @param sql
	 */
	private PreparedStatement stmt = null;
	public void excuteQuery(String sql) {

		Connection conn = getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeAll();
	}
	
	/**
	 * 查
	 */
	public ResultSet queryAll( String sql){
		
		Connection conn = getConnection();
		PreparedStatement stmt;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement( sql );
			rs = stmt.executeQuery( sql );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public void closeAll() {
		try {
			stmt.close();
			stmt = null;
		} catch (Exception e) {
			stmt = null;
		}
		try {
			conn.close();
			conn = null;
		} catch (Exception e) {
			conn = null;
		}
	}

}
