package erp_jsp_exam.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import erp_jsp_exam.dao.EmployeeDao;
import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final EmployeeDaoImpl instance = new EmployeeDaoImpl();
	private Connection con;

	public EmployeeDaoImpl() {
	}

	public static EmployeeDaoImpl getInstance() {
		return instance;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public List<Employee> selectEmployeeAll() {
		String sql = "select EMP_NO, EMP_NAME, TITLE, MANAGER, SALARY, DNO, HIREDATE from employee";
		try (PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			List<Employee> list = new ArrayList<Employee>();
			if (rs.next()) {
				do {
					list.add(getEmployee(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int eNo = rs.getInt("EMP_NO");
		String eName = rs.getString("EMP_NAME");
		Title title = new Title(rs.getInt("TITLE"));
		Employee manager = new Employee(rs.getInt("MANAGER"));
		int salary = rs.getInt("SALARY");		
		Department dep = new Department(rs.getInt("DNO"));		
		Date hireDate = rs.getTimestamp("HIREDATE");
		return new Employee(eNo, eName, title, manager, salary, dep, hireDate);
	}

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		String sql = "select EMP_NO, EMP_NAME, TITLE, MANAGER, SALARY, DNO, HIREDATE from employee"
				+ " where EMP_NO=?";
		try (PreparedStatement std = con.prepareStatement(sql);) {
			std.setInt(1, employee.geteNo());
			try (ResultSet rs = std.executeQuery()) {
				if (rs.next()) {
					return getEmployee(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int intsertEmployee(Employee employee) {
		String sql = "insert into employee  values(?,?,?,?,?,?,?)";
		try (PreparedStatement std = con.prepareStatement(sql);) {
			std.setInt(1, employee.geteNo());
			std.setString(2, employee.geteName());
			std.setInt(3, employee.getTitle().gettNo());
			std.setInt(4, employee.getManager().geteNo());
			std.setInt(5, employee.getSalary());
			std.setInt(6, employee.getDep().getdNo());
			std.setTimestamp(7, new Timestamp(employee.getHireDate().getTime()) );
			return std.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		// EMP_NO, EMP_NAME, TITLE, MANAGER, SALARY, DNO, HIREDATE
		String sql = "update employee" + 
				" set EMP_NAME = ?, TITLE = ?, MANAGER = ?, SALARY = ?, DNO= ?, HIREDATE= ?" + 
				" where EMP_NO =?";
		try (PreparedStatement std = con.prepareStatement(sql)) {
			std.setString(1, employee.geteName());
			std.setInt(2, employee.getTitle().gettNo());
			std.setInt(3, employee.getManager().geteNo());
			std.setInt(4, employee.getSalary());
			std.setInt(5, employee.getDep().getdNo());
			std.setTimestamp(6, new Timestamp(employee.getHireDate().getTime()) );
			std.setInt(7, employee.geteNo());
			return std.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmployee(Employee employee) {
		String sql = "delete from employee where EMP_NO = ?";
		try (PreparedStatement std = con.prepareStatement(sql)) {
			std.setInt(1, employee.geteNo());
			return std.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
