package com.cjon.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBTemplate {

	private Connection con;
	
	
	public DBTemplate(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			 String url = "jdbc:mysql://localhost:3306/library";
			   String id = "jQu";
			   String pw = "jQu";
			   
			   
			   con = DriverManager.getConnection(url,id,pw);
			   //3.사용할 sql을 작성하고 Preparedstatement 생성
			   
			   con.setAutoCommit(false); 
			   
		} catch (Exception e) {
			System.out.println(e);
		 }
		}
		
		public void commit(){
			try {
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}


	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public void rollback() {
        try {
	           con.rollback();
        } catch (SQLException e) {
               	e.printStackTrace();
        }		
	}
	
	
}
