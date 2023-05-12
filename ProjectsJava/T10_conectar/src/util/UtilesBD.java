package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UtilesBD {
	
	
	
		public static void printRes(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
			while(rs.next()) {
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					System.out.print(rs.getString(i)+" ");
				}
				System.out.println();
			}
		
	}
}
