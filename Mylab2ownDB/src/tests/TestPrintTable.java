/*
 * Выводим данные из таблицы
 */

package tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MyConnector;

public class TestPrintTable {

	public static void main(String[] args) {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from STUDENTS";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally{
			connector.closeConnection();
		}

		MyConnector connector1 = new MyConnector();
		Connection conn1 = connector1.getConnection();
		try {
			Statement st = conn1.createStatement();
			String sql = "select * from MARKS";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally{
			connector1.closeConnection();
		}
		
		MyConnector connector2 = new MyConnector();
		Connection conn2 = connector2.getConnection();
		
		try {
			Statement st = conn2.createStatement();
			String sql = "select * from SUBJECTS";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally{
			connector1.closeConnection();
		}
		
		

	}

}
