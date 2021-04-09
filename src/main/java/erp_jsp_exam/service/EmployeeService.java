package erp_jsp_exam.service;

import java.util.List;

import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dto.Employee;

public class EmployeeService {
	private EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	public List<Employee> allEmployees() {
		return dao.selectEmployeeAll();
	}

	public void intsertEmployee(Employee employee) {
		dao.intsertEmployee(employee);
	}

	public Employee noEmployee(Employee employee) {
		return dao.selectEmployeeByNo(employee);
	}

	public int updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}

	public int delEmployee(Employee employee) {
		return dao.deleteEmployee(employee);
	}
}
