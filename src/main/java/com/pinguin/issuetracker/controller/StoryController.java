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

import com.pinguin.issuetracker.entity.Story;
import com.pinguin.issuetracker.handler.StoryHandler;

/**
 * @author Chakraborty, Ayan
 */
@RestController
public class StoryController {

	@Autowired
	StoryHandler storyHandler;

	/**
	 * This API is used to fetch Story based on id
	 * 
	 * @param issueId
	 * @return ResponseEntity<Story>
	 */
	@GetMapping(value = "/story/getStory/{issueId}", consumes = "application/json")
	public ResponseEntity<Story> getStoryByIssueId(@PathVariable("issueId") long issueId) {
		Story story = storyHandler.getStoryByIssueId(issueId);
		return new ResponseEntity<>(story, HttpStatus.OK);
	}

	/**
	 * This API fetches all the list of Stories
	 * 
	 * @return ResponseEntity<List<Story>>
	 */
	@GetMapping(value = "/story/getStoryList")
	public ResponseEntity<List<Story>> getListOfStories() {
		List<Story> storyList = storyHandler.getListOfStories();
		return new ResponseEntity<>(storyList, HttpStatus.OK);
	}

	/**
	 * This API is used to add new Story
	 * 
	 * @param story
	 * @return ResponseEntity<Story>
	 */
	@PostMapping(value = "/story/addStory", consumes = "application/json")
	public ResponseEntity<Story> addStory(@RequestBody Story story) {
		Story newStory = storyHandler.addStory(story);
		return new ResponseEntity<>(newStory, HttpStatus.CREATED);
	}

	/**
	 * This API is used to update existing Story
	 * 
	 * @param issueId
	 * @param story
	 * @return ResponseEntity<Story>
	 */
	@PutMapping(value = "/story/updateStory/{issueId}", consumes = "application/json")
	public ResponseEntity<Story> updateStory(@PathVariable("issueId") long issueId, @RequestBody Story story) {
		try {
			Story existingStory = storyHandler.updateStory(issueId, story);
			return new ResponseEntity<>(existingStory, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This API is used to delete single story
	 * 
	 * @param issueId
	 * @return ResponseEntity<Story>
	 */
	@DeleteMapping(value = "/story/deleteStory/{issueId}")
	public ResponseEntity<HttpStatus> deleteStory(@PathVariable("issueId") long issueId) {
		try {
			storyHandler.deleteStory(issueId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This API is used to delete all stories
	 * 
	 * @return ResponseEntity<Story>
	 */
	@DeleteMapping(value = "/story/deleteAllStories")
	public ResponseEntity<Story> deleteAllStories() {
		storyHandler.deleteAllStories();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
