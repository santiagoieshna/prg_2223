package princiapl;

import java.sql.*;


import conector.ConectarBD;

public class APP {
	public static void main(String[] args) {
		ConectarBD conector = new ConectarBD();
		
		try {
			Connection con = conector.getConexion();
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("show tables");
			
			printRes(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void printRes(ResultSet rs) throws SQLException {
		while(rs.next()) {
			for (int i = 1; i <= rs.getFetchSize(); i++) {
				System.out.println(rs.getString(i));
			}
			System.out.println(rs.getFetchSize());
//			System.out.println(rs.getString(1));
		}
	}
}
