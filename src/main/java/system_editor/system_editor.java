package system_editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class system_editor {
	
	private Connection connect() 
	 { 
			Connection con = null; 
			
			try
			{ 
				Class.forName("com.mysql.jdbc.Driver"); 
	 
				//Provide the correct details: DBServer/DBName, username, password 
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget", "root", ""); 
	 
			} 
	 
			catch (Exception e) 
	 
			{e.printStackTrace();} 
	
			return con; 
	 } 
	
	public String addsystem_editor(String sid, String username, String email, String password) 
	 
	{ 
	 
		String output = ""; 
	 
		try
	 
		{ 
	 
			Connection con = connect(); 
	 
			if (con == null) 
	 
			{return "Error while connecting to the database for inserting."; } 
	 
			// create a prepared statement
	 
			String query = " insert into system_editor (`sid`,`username`,`email`,`password`)" + " values (?, ?, ?, ?)"; 
	 
			PreparedStatement Stmt = con.prepareStatement(query); 
	 
			// binding values
	
			Stmt.setInt(1, 0); 
			Stmt.setString(2, sid);  
			Stmt.setString(3, username); 
			Stmt.setString(5, email);
			Stmt.setString(4,password); 
			
			
			// execute the statement
			
			Stmt.execute(); 
			 
			con.close(); 
			 
			output = "Inserted successfully"; 
			 
		} 
			 
		catch (Exception e) 
			 
		{ 
			 
			output = "Error while inserting the item."; 
			 
			System.err.println(e.getMessage()); 
			 
		} 
			 
		return output; 
			 
	} 
			
	public String readsystem_editor() 
			 
	{ 
			 
		String output = ""; 
			 
		try
			 
		{ 
			 
			Connection con = connect(); 
			 
			if (con == null) 
			 
			{return "Error while connecting to the database for reading."; } 
			 
			// Prepare the html table to be displayed
			 
			output = "<table border='1'><tr><th>sid</th><th>username</th>" +"<th>email</th>" + 
					"<th>password</th>" +
					"<th>Update</th><th>Remove</th></tr>"; 
			 
			 
			String query = "select * from system_editor"; 
			 
			Statement stmt = con.createStatement(); 
			 
			ResultSet rs = stmt.executeQuery(query); 
			 
			// iterate through the rows in the result set
			 
			while (rs.next()) 
			 
			{ 
			 
				String sid = Integer.toString(rs.getInt("sid")); 
			 
				String username = rs.getString("username"); 
			 
				String email = rs.getString("email"); 
				
				String password = rs.getString("password"); 
			 				 
			 
				// Add into the html table
			 
				output += "<tr><td>" + sid + "</td>"; 
			 
				output += "<td>" + username + "</td>"; 
			 
				output += "<td>" + email + "</td>"; 
			 
				output += "<td>" + password + "</td>"; 
			 
				// buttons
			 
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
			 
						+ "<td><form method='post' action='system_editor.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
			 
						+ "<input name='pid' type='hidden' value='" + sid 
			 
						+ "'>" + "</form></td></tr>"; 
			 
			} 
			 
			con.close(); 
			 
			// Complete the html table
			 
			output += "</table>"; 
			 
		} 
			 
		catch (Exception e) 
			 
		{ 
			 
			output = "Error while reading the items."; 
			 
			System.err.println(e.getMessage()); 
			 
		} 
			 
		return output; 
			 
	} 
			
	public String updatesystem_editor(String sid, String username, String email, String password)
			 
	{ 
			 
		String output = ""; 
			 
		try
			 
		{ 
			 
			Connection con = connect(); 
			 
			if (con == null) 
			 
			{return "Error while connecting to the database for updating."; } 
			 
			// create a prepared statement
			 
			String query = "UPDATE system_editor SET sid=?,username=?,email=?,password=? WHERE sid=?"; 
			 
			PreparedStatement Stmt = con.prepareStatement(query); 
			 
			// binding values
			 
			Stmt.setInt(1, 0); 
			Stmt.setString(2, sid);  
			Stmt.setString(3, username); 
			Stmt.setString(5, email);
			Stmt.setString(4,password);
			// execute the statement
			 
			Stmt.execute(); 
			 
			con.close(); 
			 
			output = "Updated successfully"; 
			 
		} 
			 
		catch (Exception e) 
			 
		{ 
			 
			output = "Error while updating the item."; 
			 
			System.err.println(e.getMessage()); 
			 
		} 
			 
		return output; 
			 
	} 
			
	public String deletesystem_editor(String sid) 
			 
	{ 
			 
		String output = ""; 
			 
		try
			 
		{ 
			 
			Connection con = connect(); 
			 
			if (con == null) 
			 
			{return "Error while connecting to the database for deleting."; } 
			 
			// create a prepared statement
			 
			String query = "delete from system_editor where sid=?"; 
			 
			PreparedStatement Stmt = con.prepareStatement(query); 
			 
			// binding values
			 
			Stmt.setInt(1, Integer.parseInt(sid)); 
			 
			// execute the statement
			 
			Stmt.execute(); 
			 
			con.close(); 
			 
			output = "Deleted successfully"; 
			 
		} 
			 
		catch (Exception e) 
			 
		{ 
			 
			output = "Error while deleting the item."; 
			 
			System.err.println(e.getMessage()); 
			 
		} 
			 
		return output; 
			 
	} 

}
