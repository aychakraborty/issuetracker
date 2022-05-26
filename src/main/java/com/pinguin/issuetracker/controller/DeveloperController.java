package com.pinguin.issuetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinguin.issuetracker.entity.Developer;
import com.pinguin.issuetracker.handler.DeveloperHandler;

/**
 * @author Chakraborty, Ayan
 */
@RestController
public class DeveloperController {

	@Autowired
	DeveloperHandler developerHandler;

	/**
	 * This API fetches the list of developers
	 * 
	 * @return List<Developer>
	 */
	@GetMapping(value = "/dev/getDevelopersList")
	public ResponseEntity<List<Developer>> getListOfDevelopers() {
		List<Developer> devList = developerHandler.getListOfDevelopers();
		return new ResponseEntity<>(devList, HttpStatus.OK);
	}

	/**
	 * This API is used to add new developers
	 * 
	 * @param developer
	 * @return ResponseEntity<Developer>
	 */
	@PostMapping(value = "/dev/addDeveloper", consumes = "application/json")
	public ResponseEntity<Developer> addDeveloper(@RequestBody Developer developer) {
		Developer newDeveloper = developerHandler.addDeveloper(developer);
		return new ResponseEntity<>(newDeveloper, HttpStatus.CREATED);
	}

	/**
	 * This API is used to update existing developers
	 * 
	 * @param id
	 * @param developer
	 * @return ResponseEntity<Developer>
	 */
	@PutMapping(value = "/dev/updateDeveloper/{id}", consumes = "application/json")
	public ResponseEntity<Developer> updateDeveloper(@PathVariable("id") long id, @RequestBody Developer developer) {
		try {
			Developer existingDev = developerHandler.updateDeveloper(id, developer);
			return new ResponseEntity<>(existingDev, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This API is used to delete developers based on id
	 * 
	 * @param id
	 * @return ResponseEntity<Developer>
	 */
	@DeleteMapping(value = "/dev/deleteDeveloper/{id}")
	public ResponseEntity<HttpStatus> deleteDeveloper(@PathVariable("id") long id) {
		try {
			developerHandler.deleteDeveloper(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This API is used to delete all developers
	 * 
	 * @return
	 */
	@DeleteMapping(value = "/dev/deleteAllDevelopers")
	public ResponseEntity<Developer> deleteAllDevelopers() {
		developerHandler.deleteAllDevelopers();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
