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

import com.course.assignment.dto.InstanceDTO;
import com.course.assignment.entities.Instance;
import com.course.assignment.service.InstanceServiceImpl;





@RestController
public class InstanceController {
	
	
	@Autowired
	InstanceServiceImpl instanceService ;
	
	
	
	@GetMapping("/instances")
	 public ResponseEntity<List<Instance>> getAllInstances() {
        List<Instance> instances = instanceService.getAllInstances();
        return new ResponseEntity<>(instances, HttpStatus.OK);
    }
	
	
	
	@PostMapping("/add-instance")
	public ResponseEntity<Instance> createInstance(@RequestBody InstanceDTO instanceDTO) {
		Instance savedInstance = instanceService.saveInstance(instanceDTO.getYear(), instanceDTO.getSemester(), instanceDTO.getCourseCode());
		 return new ResponseEntity<>(savedInstance, HttpStatus.CREATED); 
	}
	
	 @DeleteMapping("/instance/{id}")
	 public ResponseEntity<Void> deleteInstance(@PathVariable Long id) {
	        instanceService.deleteInstance(id);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	
	

}
