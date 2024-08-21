package com.course.assignment.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.assignment.entities.Course;
import com.course.assignment.repository.CourseRepository;



@Service
public class CourseServiceImpl {
	
	@Autowired
	CourseRepository courseRepository ;
	
	public List<Course> getAllCourses() {
		return  courseRepository.findAll() ;
	}
	 
	public Course saveCourse(Course course) { 
		return courseRepository.save(course) ;
	}
	
	public Course getCourseById(String courseCode) {
		return courseRepository.findByCourseCode(courseCode);
	}
	
	public void deleteCourseById(Long id) {
		courseRepository.deleteById(id);
	}
	  
	 
 
}
