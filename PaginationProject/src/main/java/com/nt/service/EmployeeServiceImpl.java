package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.EmptyOperator;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.domain.EmployeeDomain;
import com.nt.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public long getReportPagesCount(int pageSize) {
		EmployeeDAO dao = null;
		long empCount = 0;
		long pageCount = 0;
		// getDAO
		dao = EmployeeDAOFactory.getInstance();
		// use DAO here
		empCount = dao.getEmployeeCount();
		if (empCount % pageSize == 0) {
			empCount = empCount / pageSize;
		} else {
			empCount = empCount / pageSize;
			empCount++;
		}
		return empCount;

	}

	@Override
	public List<EmployeeDTO> getReportPageData(int pagetNo, int pageSize) {
		int startPosition = 0;
		EmployeeDTO dto = null;
		EmployeeDomain domain = null;
		EmployeeDAO dao = null;
		List<EmployeeDomain> listDomain = null;
		List<EmployeeDTO> listDTO = null;
		// get statrting position
		startPosition = (pagetNo * pageSize) - pageSize;
		// convert listDomain to listDTO
		listDTO = new ArrayList<>();
		for (EmployeeDTO employeeDTO : listDTO) {
			dto = new EmployeeDTO();
			dto.setEmpno(domain.getEmpno());
			dto.setEname(domain.getEname());
			dto.setJob(domain.getJob());
			dto.setSal(dto.getSal());
			// add dto to listdto which can display on page
			listDTO.add(dto);
		} // for
		return listDTO;
	}// getReportPageData

}// class
