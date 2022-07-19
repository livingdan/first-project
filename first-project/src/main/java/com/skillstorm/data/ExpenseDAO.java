package com.skillstorm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import com.skillstorm.beans.Expense;
import com.skillstorm.beans.ReimbursementStatus;

public class ExpenseDAO implements AutoCloseable {
	


	private Connection connection;
	
	
	public ExpenseDAO() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/reimbursement";
		String username = "root";
		String password = "root";
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
	    this.connection = DriverManager.getConnection(url, username, password);
		
		
	}
	
	//CRUD
	public Expense create(Expense expense) throws SQLException {
		String sql = "insert into expense(name, reason, notes) VALUES (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, expense.getName());
		statement.setString(2, expense.getReason());
		statement.setString(3, expense.getNotes());
		
		// returns number of rows affected
		statement.executeUpdate();
		// grab the id - ResultSet = statement.getGeneratedKeys()
		ResultSet rs = statement.getGeneratedKeys(); 
		rs.next();
		int generatedId = rs.getInt(1);
		expense.setId(generatedId);
		expense.setStatus(new ReimbursementStatus(getStatusId(expense), getStatus(expense)));
		return expense;
	
	}
	
	public boolean updateStatus(Expense expense) throws SQLException {
		String sql = "update expense set statusId = ? where ExpenseId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		int change = expense.getStatus().getStatusId();
		statement.setInt(1, change); 
		statement.setInt(2, expense.getId());
		
		expense.setStatus(new ReimbursementStatus(change,getStatus(expense)));
		
		return statement.executeUpdate() == 1;
	}
	public int getStatusId(Expense expense) throws SQLException {
		String sql = "select statusId from expense where expenseId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, expense.getId());
		
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			// get artist
			return rs.getInt("statusId");
		} else {
			return 0;
		}
	}
	public String getStatus(Expense expense) throws SQLException {
		String sql = "select status from reimbursement_status \r\n"
				+ "	inner join expense on reimbursement_status.statusId = expense.statusId \r\n"
				+ "    where expenseId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, expense.getId());
		
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			return rs.getString("status");
		} else {
			return null;
		}
	}
	
	
	public boolean delete(int id) throws SQLException {
		String sql = "delete from expense where expenseId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		return statement.executeUpdate() == 1;
	}

	@Override
	public void close() throws Exception {
		if( connection != null && !connection.isClosed()) {
			this.connection.close();
		}
		
	}



	public Set<Expense> findAll() throws SQLException {
		Set<Expense> expenses = new LinkedHashSet<Expense>();
		String sql = "select expenseId, name, reason, notes, statusId from expense";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			Expense row = new Expense();
			int id = resultSet.getInt("expenseId");
			String name = resultSet.getString("name");
			String reason = resultSet.getString("reason");
			String notes = resultSet.getString("notes");
			
			row.setId(id);
			row.setName(name);
			row.setReason(reason);
			row.setNotes(notes);
			row.setStatus(new ReimbursementStatus(getStatusId(row), getStatus(row)));
			expenses.add(row);
			
		}
		return expenses;
		
		
	}
}
