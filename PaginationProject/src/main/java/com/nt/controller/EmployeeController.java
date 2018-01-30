package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;
import com.nt.service.EmployeeServiceFactoty;

public class EmployeeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageSize = 0;
		int pageNo = 0;
		long pageCount = 0;
		EmployeeService service = null;
		List<EmployeeDTO> dto = null;
		RequestDispatcher rd = null;
		// read the form data
		pageSize = Integer.parseInt(req.getParameter("pageSize"));
		if (req.getParameter("pageNo") == null || req.getParameter("pageNo").length() == 0)
			pageNo = 1;
		else
			pageNo = Integer.parseInt(req.getParameter("pageNo"));
		// use Service class
		service = EmployeeServiceFactoty.getInstance();
		// get the report Data in listDTO to transfer on page
		dto = service.getReportPageData(pageNo, pageSize);
		// get pageCount
		pageCount = service.getReportPagesCount(pageSize);
		// keep Result In Request Scope
		req.setAttribute("reportData", dto);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("pageSize", pageSize);
		req.setAttribute("pageNo", pageNo);
		// forward to report.jsp
		rd = req.getRequestDispatcher("/report.jsp");
		rd.forward(req, resp);
	}// doGet(-,-)

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}// class
