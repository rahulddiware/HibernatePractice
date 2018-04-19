package com.rd.hibernate.SpringHibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rd.hibernate.SpringHibernate.entity.Course;

@Repository
public class CourseRepository {
	@Autowired
	private EntityManager em;

	public Course getCourseById(int id) {
		return em.find(Course.class, id);
	}// getCourseById

}
