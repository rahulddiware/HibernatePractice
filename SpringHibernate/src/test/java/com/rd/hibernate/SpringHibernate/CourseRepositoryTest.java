package com.rd.hibernate.SpringHibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rd.hibernate.SpringHibernate.entity.Course;
import com.rd.hibernate.SpringHibernate.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringHibernateApplication.class)
public class CourseRepositoryTest {
	@Autowired
	CourseRepository repository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * @Test public void findById() { Course course =
	 * repository.getCourseById(1001); assertEquals(1002, course.getId()); }
	 */
	@Test
	public void deleteById() {
		repository.deletById(1002);
		assertNull(repository.getCourseById(1002));
	}

}
