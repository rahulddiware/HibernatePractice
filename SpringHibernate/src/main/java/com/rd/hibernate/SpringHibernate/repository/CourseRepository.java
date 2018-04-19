package com.rd.hibernate.SpringHibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rd.hibernate.SpringHibernate.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	private EntityManager em;

	public Course getCourseById(int id) {
		return em.find(Course.class, id);
	}// getCourseById

	public void deletById(int id) {
		Course course = em.find(Course.class, id);
		em.remove(course);
	}

}
