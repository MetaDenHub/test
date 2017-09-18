package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MyConnector;

public class SUBJECTS {
	public static void main(String[] args) {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("create table SUBJECTS ("
					+ "ID integer generated always as identity,"
					+ "SUBJECT varchar(30), " 
					+ "primary key (ID))");
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally{
			connector.closeConnection();
		}
	}
}
