package com.course.assignment.dto;

public class CourseDTO {
	
    private String title;
    private String courseCode;
    private String description;
    
    public CourseDTO() {}

    public CourseDTO(String title, String courseCode, String description) {
        this.title = title;
        this.courseCode = courseCode;
        this.description = description;
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

}
