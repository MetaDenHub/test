/*
 * Заполняем созданную таблицу данными
 */


package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MyConnector;

public class TestInsert {

	public static void main(String[] args) {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
			String name = "Козак І.П.";
			st.executeUpdate("insert into STUDENTS(NAME) values('" + name + "')");
			String sql = "insert into STUDENTS(NAME) values(" + "'Мамай К.М.'" + ")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}
		
		Connection conn1 = connector.getConnection();
		try {
			Statement st = conn1.createStatement();
			//Integer mark = 5;
			st.executeUpdate("insert into MARKS(MARK) values(" + 5 + ")");
			String sql = "insert into MARKS(MARK) values(" + 5 + ")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}
		
		Connection conn2 = connector.getConnection();
		try {
			Statement st = conn2.createStatement();
			String subject = "Math";
			st.executeUpdate("insert into SUBJECTS(SUBJECT) values('" + subject + "')");
			String sql = "insert into SUBJECTS(SUBJECT) values(" + "'Physics'" + ")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}

	}

}
