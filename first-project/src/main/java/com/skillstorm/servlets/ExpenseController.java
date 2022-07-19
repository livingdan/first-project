package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.Expense;
import com.skillstorm.data.ExpenseDAO;



@WebServlet(urlPatterns = "/*")
public class ExpenseController extends HttpServlet {
	
	//private ExpenseDAO dao = new ExpenseDAO();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Set<Expense> expenseList = null;
		try(ExpenseDAO dao = new ExpenseDAO()) {
			expenseList = dao.findAll();
			System.out.println(expenseList);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (expenseList != null) {
			String json = new ObjectMapper().writeValueAsString(expenseList);
			resp.getWriter().print(json);
			resp.setContentType("application/json");
		}
		
		
	}

	// add
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		InputStream requestBody = req.getInputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		Expense expense = objectMapper.readValue(requestBody, Expense.class);
		System.out.println(expense);
	
		try(ExpenseDAO dao = new ExpenseDAO()) {
			dao.create(expense);
			System.out.println("post");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream requestBody = req.getInputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		Expense expense = objectMapper.readValue(requestBody, Expense.class);
		System.out.println(expense);
	
		try(ExpenseDAO dao = new ExpenseDAO()) {
			dao.create(expense);
			System.out.println("post");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
