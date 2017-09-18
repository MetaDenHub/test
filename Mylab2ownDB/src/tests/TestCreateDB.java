/*
 * Создаем базу данных
 */


package tests;

import java.sql.Connection;

import controller.MyConnector;

public class TestCreateDB {
	public static void main(String[] args) {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		System.out.println(conn);
		connector.closeConnection();
	}
}
