package com.test.util;

import java.sql.*;

public class DBUtils {
	
	public Connection con;
	public ResultSet rs;
	public Statement st;
	
	public ResultSet getValues(String sql)
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=abc;user=sa;password=sa");
			st=con.createStatement();
			rs=st.executeQuery(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public void updateResults(String sql)
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=abc;user=sa;password=sa");
			st=con.createStatement();
			st.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
