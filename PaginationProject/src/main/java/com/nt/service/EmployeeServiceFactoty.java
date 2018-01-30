package com.nt.service;

public class EmployeeServiceFactoty {
	public static EmployeeService getInstance() {
		return new EmployeeServiceImpl();
	}//getInstance

}//class
