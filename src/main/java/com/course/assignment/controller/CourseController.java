package com.course.assignment.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.assignment.dto.CourseDTO;
import com.course.assignment.entities.Course;
import com.course.assignment.service.CourseServiceImpl;







@RestController 
public class CourseController {
	
	@Autowired
	CourseServiceImpl courseService ;

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourse() {
		List<Course> courses = courseService.getAllCourses();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	} 
	
	@GetMapping("/course/{courseCode}")
	public ResponseEntity<Course> getCourseById(@PathVariable String courseCode){
		Course course = courseService.getCourseById(courseCode) ;
		 
			return new ResponseEntity<>(course,HttpStatus.OK) ;   
		
		
	}
	
	@PostMapping("/add-course")
	public ResponseEntity<Course> saveCourse(@RequestBody CourseDTO courseDTO) {
		
		Course course = new Course(courseDTO.getTitle(), courseDTO.getCourseCode(), courseDTO.getDescription());		
		Course savedCourse = courseService.saveCourse(course); 
		 
		return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);   
	}
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
		  	courseService.deleteCourseById(id) ;
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
