package com.course.assignment.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.assignment.entities.Course;
import com.course.assignment.entities.Instance;
import com.course.assignment.repository.CourseRepository;
import com.course.assignment.repository.InstanceRepository;



@Service
public class InstanceServiceImpl {

	@Autowired
	InstanceRepository instanceRepository ;
	 
	
	  @Autowired
	    private CourseRepository courseRepository;
	
	 public Optional<Instance> getInstanceById(Long id) {
	        return instanceRepository.findById(id);
	    }
	
	 public Instance saveInstance(int year, int semester, String courseCode) {
	        // Fetch the Course using courseCode
	        Course course = courseRepository.findByCourseCode(courseCode);
	        if (course == null) {
	            throw new IllegalArgumentException("Course with code " + courseCode + " not found.");
	        }

	        // Create a new Instance and associate it with the fetched Course
	        Instance instance = new Instance(year, semester, courseCode);
	        instance.setCourse(course); // Set the course

	        // Save and return the instance
	        return instanceRepository.save(instance);
	    }
	 
	public List<Instance> getAllInstances() {
        return instanceRepository.findAll();
    }
	
	public void deleteInstance(Long id) {
		instanceRepository.deleteById(id);  ; 
	}
}
