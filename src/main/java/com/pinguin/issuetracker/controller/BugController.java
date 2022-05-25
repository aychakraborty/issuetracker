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

import com.pinguin.issuetracker.entity.Bug;
import com.pinguin.issuetracker.handler.BugHandler;

/**
 * @author Chakraborty, Ayan
 */
@RestController
public class BugController {

	@Autowired
	BugHandler bugHandler;

	/**
	 * This API fetches Bug based on id
	 * 
	 * @param issueId
	 * @return ResponseEntity<Bug>
	 */
	@GetMapping(value = "/bug/getBug/{issueId}", consumes = "application/json")
	public ResponseEntity<Bug> getBugByIssueId(@PathVariable("issueId") long issueId) {
		Bug bug = bugHandler.getBugByIssueId(issueId);
		return new ResponseEntity<>(bug, HttpStatus.OK);
	}

	/**
	 * This API fetches list of Bugs
	 * 
	 * @return ResponseEntity<List<Bug>>
	 */
	@GetMapping(value = "/bug/getBugList")
	public ResponseEntity<List<Bug>> getListOfBugs() {
		List<Bug> bugList = bugHandler.getListOfBugs();
		return new ResponseEntity<>(bugList, HttpStatus.OK);
	}

	/**
	 * This API is used to add new Bug
	 * 
	 * @param bug
	 * @return ResponseEntity<Bug>
	 */
	@PostMapping(value = "/bug/addBug", consumes = "application/json")
	public ResponseEntity<Bug> addBug(@RequestBody Bug bug) {
		try {
			Bug newBug = bugHandler.addBug(bug);
			return new ResponseEntity<>(newBug, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This API is used to update existing bug
	 * 
	 * @param issueId
	 * @param bug
	 * @return ResponseEntity<Bug>
	 */
	@PutMapping(value = "/bug/updateBug/{issueId}", consumes = "application/json")
	public ResponseEntity<Bug> updateBug(@PathVariable("issueId") long issueId, @RequestBody Bug bug) {
		try {
			Bug existingBug = bugHandler.updateBug(issueId, bug);
			return new ResponseEntity<>(existingBug, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This API is used to delete single bug
	 * 
	 * @param issueId
	 * @return ResponseEntity<Bug>
	 */
	@DeleteMapping(value = "/bug/deleteBug/{issueId}")
	public ResponseEntity<Bug> deleteBug(@PathVariable("issueId") long issueId) {
		try {
			bugHandler.deleteBug(issueId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This API is used to delete all bugs
	 * 
	 * @return ResponseEntity<Bug>
	 */
	@DeleteMapping(value = "/bug/deleteAllBugs")
	public ResponseEntity<Bug> deleteAllBugs() {
		bugHandler.deleteAllBugs();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
