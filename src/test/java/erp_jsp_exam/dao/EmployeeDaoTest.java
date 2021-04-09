package erp_jsp_exam.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.dto.Title;
import erp_jsp_exam.util.JdbcUtilTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	private static Connection con;
	private static EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtilTest.getConnection();
		dao.setCon(con);
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
	}

	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectEmployeeAll() {
		System.out.printf("%s()%n", "test01SelectEmployeeAll");

		List<Employee> list = dao.selectEmployeeAll();
		Assert.assertNotNull(list);		
	}

	@Test
	public void test04SelectEmployeeByNo() {
		System.out.printf("%s()%n", "test04SelectEmployeeByNo");

		Employee employee = new Employee(4377);
		Employee noEmp = dao.selectEmployeeByNo(employee);
		Assert.assertNotNull(noEmp);
	}

	@Test
	public void test02IntsertEmployee() {
		System.out.printf("%s()%n", "test02IntsertEmployee");

		Employee employee = new Employee(1111, "이정호", new Title(5), new Employee(4377), 1500000, new Department(2),new Date());
		int res = dao.intsertEmployee(employee);

		Assert.assertEquals(1, res);
	}

	@Test
	public void test03UpdateEmployee() {
		System.out.printf("%s()%n", "test03UpdateEmployee");

		Employee employee = new Employee(1111, "이정호1", new Title(5), new Employee(4377), 1500000, new Department(2),new Date());
		int res = dao.updateEmployee(employee);

		Assert.assertEquals(1, res);
	}

	@Test
	public void test05DeleteEmployee() {
		System.out.printf("%s()%n", "test05DeleteEmployee");

		Employee employee = new Employee(1111);
		int res = dao.deleteEmployee(employee);

		Assert.assertEquals(1, res);
	}

}
