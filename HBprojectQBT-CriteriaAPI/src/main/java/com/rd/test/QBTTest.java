package com.rd.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.nt.domain.EmployeeHLO;
import com.nt.utility.HibernateUtil;

public class QBTTest {

	public static void main(String[] args) {
		Session sess = null;
		Criteria criteria = null;
		List<EmployeeHLO> list = null;
		Criterion cond1 = null, cond2 = null, cond3 = null;
		// get Session
		sess = HibernateUtil.getSession();
		/*
		 * // create Criteria Object criteria = sess.createCriteria(EmployeeHLO.class);
		 * // execute QBC and store in the list collection list = criteria.list(); //
		 * process the result for (EmployeeHLO employeeHLO : list) {
		 * System.out.println(employeeHLO.getEmpno()); }
		 */
		// execute QBC logic with one condition
		// prepare Criteria object
		/*
		 * criteria = sess.createCriteria(EmployeeHLO.class); // prepare condition
		 * (Criterion object) cond1 = Restrictions.between("empno", 100, 7000); // add
		 * condition criteria.add(cond1); // execute QBC logic list = criteria.list();
		 * // process the result for (EmployeeHLO ed : list) {
		 * System.out.println(ed.getEname()); }
		 */
		// execute QBC logic with two conditions
		// prepare Criteria object
		criteria = sess.createCriteria(EmployeeHLO.class);
		// prepare conditions
		cond1 = Restrictions.like("job", "%salesman");
		cond2 = Restrictions.like("ename", "%m");
		// add conditions
		criteria.add(cond1);
		criteria.add(cond2);
		// execute logic
		list = criteria.list();
		// process the result
		for (EmployeeHLO ed : list) {
			System.out.println(ed.getEmpno());
		}

	}// main

}// class
