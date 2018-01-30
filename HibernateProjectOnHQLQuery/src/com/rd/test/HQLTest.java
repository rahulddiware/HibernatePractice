package com.rd.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rd.doamin.EmployeeDomain;
import com.rd.utility.HibernateUtil;

public class HQLTest {
	public static void main(String[] args) {
		Session sess = null;
		Query query = null;
		List<EmployeeDomain> list = null;
		List<Object[]> list1 = null;
		EmployeeDomain details = null;
		Transaction tx = null;
		int result = 0;
		// get Session
		sess = HibernateUtil.getSession();
		/*
		 * // create HQL query query =
		 * sess.createQuery("select ed from EmployeeDomain ed"); // execute the HQL
		 * query list = query.list(); // process the result for (EmployeeDomain
		 * employeeDomain : list) { System.out.println(employeeDomain.getEmpno()); }
		 */
		// crate HQL query with positional parameter
		/*
		 * query = sess.createQuery("from EmployeeDomain where empno>=? and empno<=?");
		 * // setting value to query param query.setInteger(0, 7000);
		 * query.setInteger(1, 7580); // execute the query list = query.list(); //
		 * process the result for (EmployeeDomain employeeDomain : list) {
		 * System.out.println(employeeDomain.getEmpno()); }
		 */
		// create HQL query with JPA Style positional parameter
		/*
		 * query =
		 * sess.createQuery("from EmployeeDomain where empno>=?1 and empno<=?2"); //
		 * setting values to the query param query.setInteger(1, 100);
		 * query.setInteger(2, 200); // execute the query list = query.list(); //
		 * generate the result for (EmployeeDomain employeeDomain : list) {
		 * System.out.println(employeeDomain.getEmpno() + " ------- " +
		 * employeeDomain.getEname()); }
		 */
		// creating HQL query with named Parameter
		/*
		 * query =
		 * sess.createQuery(" from EmployeeDomain where empno>=:min and empno<=:max");
		 * // set the value to the named parameter query.setInteger("min", 1000);
		 * query.setInteger("max", 2000); // execute the query list = query.list(); //
		 * process the result for (EmployeeDomain employeeDomain : list) {
		 * System.out.println(employeeDomain.getEmpno() + " ------- " +
		 * employeeDomain.getEname()); }
		 */
		// create HQL Select Query that gives specific multiple col values*
		/*
		 * query = sess.
		 * createQuery("select ename,empno,job from EmployeeDomain where job like :job"
		 * ); // set param values query.setString("job", "%Tea"); // execute the Query
		 * list1 = query.list(); // List Collection with Object class obj[] // process
		 * the result for (Object row[] : list1) { for (Object val : row) {
		 * System.out.print(val + " "); } // for } // forexecute the query
		 */
		// create non-select HQL query to delete
		/*
		 * query = sess.createQuery("delete from EmployeeDomain where job like :job");
		 * query.setString("job", "%Tea"); try { tx = sess.beginTransaction(); result =
		 * query.executeUpdate(); tx.commit(); if (result == 0)
		 * System.out.println("Record not deleted"); else System.out.println(result +
		 * " no.of Records are deleted"); } // try catch (Exception se) { tx.rollback();
		 * }
		 */
		// create HQL select query with sub query support
		/*
		 * query = sess.
		 * createQuery("from EmployeeDomain where empno=(select min(empno) from EmployeeDomain)"
		 * ); list = query.list(); details = list.get(0);
		 * System.out.println(details.getEmpno());
		 * 
		 * // close objects HibernateUtil.closeSession();
		 * HibernateUtil.closeSessionFactory();
		 */

	}// main

}// class