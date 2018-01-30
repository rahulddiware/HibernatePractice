package com.nt.dao;

import java.util.List;

import com.nt.domain.EmployeeDomain;

public interface EmployeeDAO {
	public long getEmployeeCount();

	public List<EmployeeDomain> getEmployees(int startPos, int pageSize);
}
