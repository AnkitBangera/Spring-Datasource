package org.Spring.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.Spring.Model.Circle;

public class DaoImpl {
	public Circle getCircle(int circleid) {
		Connection connection = null;
		try {
			String driver = "org.apache.derby.jdbc.ClientDriver";
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM circle where num= ?");
			ps.setInt(1, circleid);

			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				circle = new Circle(circleid, rs.getString("name"));

			}
			
			rs.close();
			ps.close();
			return circle;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
