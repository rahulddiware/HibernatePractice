package com.rd.hibernate.SpringHibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rd.hibernate.SpringHibernate.entity.Course;
import com.rd.hibernate.SpringHibernate.repository.CourseRepository;

@SpringBootApplication
public class SpringHibernateApplication implements CommandLineRunner {
	@Autowired
	private CourseRepository courseRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.getCourseById(1001);
		logger.info("course{}->", course);
		courseRepository.deletById(1001);
		logger.info("course deleted{}-->", course);

	}
}
