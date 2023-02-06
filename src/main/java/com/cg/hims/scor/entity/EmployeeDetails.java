package com.cg.hims.scor.entity;

public class EmployeeDetails {

	private int EmployeeId;
	private String empFirstName;
	private String empLastName;
	private String empMail;
	
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDetails(int employeeId, String empFirstName, String empLastName, String empMail) {
		super();
		EmployeeId = employeeId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empMail = empMail;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [EmployeeId=" + EmployeeId + ", empFirstName=" + empFirstName + ", empLastName="
				+ empLastName + ", empMail=" + empMail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + EmployeeId;
		result = prime * result + ((empFirstName == null) ? 0 : empFirstName.hashCode());
		result = prime * result + ((empLastName == null) ? 0 : empLastName.hashCode());
		result = prime * result + ((empMail == null) ? 0 : empMail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDetails other = (EmployeeDetails) obj;
		if (EmployeeId != other.EmployeeId)
			return false;
		if (empFirstName == null) {
			if (other.empFirstName != null)
				return false;
		} else if (!empFirstName.equals(other.empFirstName))
			return false;
		if (empLastName == null) {
			if (other.empLastName != null)
				return false;
		} else if (!empLastName.equals(other.empLastName))
			return false;
		if (empMail == null) {
			if (other.empMail != null)
				return false;
		} else if (!empMail.equals(other.empMail))
			return false;
		return true;
	}
	
	
	
	
}
