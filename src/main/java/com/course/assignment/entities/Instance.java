package com.course.assignment.entities;







import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="instances")
public class Instance {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Column(nullable = false)
	    private int year;

	    @Column(nullable = false)
	    private int semester; 
	
	    @Column(nullable = false)
	    private String courseCode;
	    

	    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	    @JoinColumn(name = "course_id", nullable = false)
	    @JsonIgnore 
	    private Course course;
	     
	     
	    public Instance(int year, int semester, String courseCode) {
	        this.year = year;
	        this.semester = semester;
	        this.courseCode = courseCode;
	    }

		public Instance() {
			super();
		}

		  public Long getId() {
		        return id;
		    }

		    public void setId(Long id) {
		        this.id = id;
		    }

		    public int getYear() {
		        return year;
		    }

		    public void setYear(int year) {
		        this.year = year;
		    }

		    public int getSemester() {
		        return semester;
		    }

		    public void setSemester(int semester) {
		        this.semester = semester;
		    }

		    public Course getCourse() {
		        return course;
		    }

		    public void setCourse(Course course) {
		        this.course = course;
		        if (course != null) {
		            this.courseCode = course.getCourseCode();
		        } else {
		            this.courseCode = null;
		        }
		    }

		    public String getCourseCode() {
		        return courseCode;
		    }

		    public void setCourseCode(String courseCode) {
		        this.courseCode = courseCode;
		    }
		
		 
		 

	    

}
