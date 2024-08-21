package com.course.assignment.entities;




import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String courseCode;

    @Column(length = 500)
    private String description;  

    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore 
    private Set<Instance> instances = new HashSet<>();


	public Course(String title, String courseCode, String description) {
		super();
		this.title = title;
		this.courseCode = courseCode;
		this.description = description;
	}


	public Course() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Instance> getInstances() {
		return instances;
	}


	public void setInstances(Set<Instance> instances) {
		this.instances = instances;
	}
    
    
	


}

