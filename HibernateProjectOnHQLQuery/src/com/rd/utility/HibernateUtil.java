package com.rd.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static ThreadLocal<Session> threadLocal = new ThreadLocal();
	private static SessionFactory factory = null;
	static {
		factory = new Configuration().configure("/com/rd/cfgs/hibernate.cfg.xml").buildSessionFactory();
		System.out.println("SessionFactory hashCode::" + factory.hashCode());
	}

	public static Session getSession() {
		Session ses = null;
		ses = threadLocal.get();
		if (ses == null) {
			ses = factory.openSession();
			threadLocal.set(ses);
		}
		System.out.println("Session obj hashcode::" + ses.hashCode());
		return ses;
	}// getSession()

	public static void closeSession() {
		Session ses = null;

		ses = threadLocal.get();
		if (ses != null) {
			ses.close();
			threadLocal.remove();
		}
	}

	public static void closeSessionFactory() {
		factory.close();
	}

}// class
