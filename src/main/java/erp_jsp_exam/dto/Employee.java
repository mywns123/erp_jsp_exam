package erp_jsp_exam.dto;

import java.util.Date;

public class Employee {
	private int eNo;
	private String eName;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dep;
	private Date hireDate;

	public Employee() {
	}

	public Employee(int eNo) {
		this.eNo = eNo;
	}
	

	public Employee(int eNo, String eName, Title title, Employee manager, int salary, Department dep, Date hireDate) {
		super();
		this.eNo = eNo;
		this.eName = eName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dep = dep;
		this.hireDate = hireDate;
	}

	public int geteNo() {
		return eNo;
	}

	public void seteNo(int eNo) {
		this.eNo = eNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return String.format("Employee [eNo=%s, eName=%s, title=%s, manager=%s, salary=%s, dep=%s, hireDate=%s]", eNo,
				eName, title, manager, salary, dep, hireDate);
	}

	

}
