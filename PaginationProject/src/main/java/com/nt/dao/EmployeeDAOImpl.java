package com.nt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nt.domain.EmployeeDomain;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public long getEmployeeCount() {
		Session ses = null;
		Criteria criteria = null;
		Projection rowCount = null;
		long empsCount = 0;
		List<Object> list = null;
		// get Session
		ses = HibernateUtil.getSession();
		// Use QBC with projection to get EmployeeCount
		criteria = ses.createCriteria(EmployeeDomain.class);
		rowCount = Projections.rowCount();
		criteria.setProjection(rowCount);
		list = criteria.list();
		empsCount = (long) list.get(0);
		return empsCount;
	}

	@Override
	public List<EmployeeDomain> getEmployees(int startPos, int pageSize) {
		Session ses = null;
		Criteria criteria = null;
		List<EmployeeDomain> list = null;
		// get Hibernate Session
		ses = HibernateUtil.getSession();
		// use QBC to get the list of employee form db
		criteria = ses.createCriteria(EmployeeDomain.class);
		// set pagination Param value
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(pageSize);
		// execute qbc logic
		list = criteria.list();
		return list;
	}

}
