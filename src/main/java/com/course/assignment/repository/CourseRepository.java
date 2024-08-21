package com.course.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.assignment.entities.Course;



public interface CourseRepository extends JpaRepository<Course, Long> {
	public Course findByCourseCode(String courseCode);
}
