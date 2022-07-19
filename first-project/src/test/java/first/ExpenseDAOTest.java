package first;

import org.junit.Test;

import com.skillstorm.beans.Expense;
import com.skillstorm.data.ExpenseDAO;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Set;

import org.junit.BeforeClass;


public class ExpenseDAOTest {

	
	static ExpenseDAO dao;
	
	@BeforeClass
	public static void setup() {
		try {
			dao = new ExpenseDAO();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	@Test
	public void create() {
		
		Expense ex = new Expense("ttest","test","test");
		System.out.println();
		try {

			Expense object = dao.create(ex);
			
			dao.updateStatus(object);
			System.out.println(object);
			//assertEquals(true, success);
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void findALL() {
		try {

			Set<Expense> expenseList = dao.findAll();
			
			System.out.println(expenseList);
			//assertEquals(true, success);
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
//public static void main(String[] args) {
//ExpenseDAO dao = null;
//
//try {
//	dao = new ExpenseDAO();
//} catch (SQLException e) {
//	e.printStackTrace();
//}
//
//
//try {
//
//	Expense object = dao.create(new Expense("name","purchase","no notes"));
//	System.out.println(object);
//	//assertEquals(true, success);
//} catch (SQLException e) {
//	e.printStackTrace();
//}
//
//try {
//	boolean deleted = dao.delete(2);
//	System.out.println(deleted);
//	
//} catch (SQLException e) {
//	e.printStackTrace();
//	
//}
//
//try {
//	boolean updated = dao.updateStatus(new Expense(3,"name","purchase","no notes",1));
//	System.out.println(updated);
//	
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//	
//}
//
//
//}