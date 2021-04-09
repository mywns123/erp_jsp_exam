package erp_jsp_exam.dto;

public class Department {
	private int dNo;
	private String dName;
	private int floor;

	public Department() {
	}

	public Department(int dNo) {
		this.dNo = dNo;
	}

	public Department(int dNo, String dName, int floor) {
		this.dNo = dNo;
		this.dName = dName;
		this.floor = floor;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return String.format("Department [dNo=%s, dName=%s, floor=%s]", dNo, dName, floor);
	}

}
