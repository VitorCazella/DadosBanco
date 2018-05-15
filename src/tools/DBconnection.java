package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBconnection {
	
	public static Scanner scan = new Scanner(System.in);
	
	private Connection conn = null;
	
	public Connection getConn() {
		return conn;
	}
	
	public void executeSQL(String sql) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			if (stmt.execute(sql)) {
				rs = stmt.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getString(1) + " - " + rs.getString(2));
				}
			}else {
				int count = stmt.getUpdateCount();
				if(count >= 1) {
					System.out.println("Aluno inserido com sucesso");
					System.out.println("número de linhas afetadas: " + count);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public DBconnection() {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/13100184?user=root&password=cazella1998");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
