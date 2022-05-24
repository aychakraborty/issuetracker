package com.pinguin.issuetracker.handler;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinguin.issuetracker.dao.DeveloperDao;
import com.pinguin.issuetracker.dao.StoryDao;
import com.pinguin.issuetracker.entity.Story;
import com.pinguin.issuetracker.enums.Status;

/**
 * @author Chakraborty, Ayan
 */
@Service
public class StoryHandler {

	@Autowired
	StoryDao storyDao;

	@Autowired
	DeveloperDao developerDao;

	public Story getStoryByIssueId(long issueId) {
		Optional<Story> storyData = storyDao.findById(issueId);
		if (storyData.isPresent()) {
			return storyData.get();
		}
		return null;
	}

	public List<Story> getListOfStories() {
		return storyDao.findAll();
	}

	public Story addStory(Story story) {
		// Set default story status if its not estimated
		if (Objects.nonNull(story) && Objects.isNull(story.getStatus())) {
			if (Objects.nonNull(story.getEstPointVal())) {
				story.setStatus(Status.ESTIMATED);
			} else {
				story.setStatus(Status.NEW);
			}
		}
		// Set create story date to present date
		story.setCreateDt(LocalDate.now());
		// Save story
		return storyDao.save(new Story(story.getTitle(), story.getDescription(), story.getCreateDt(),
				story.getEstPointVal(), story.getStatus()));
	}

	public Story updateStory(long issueId, Story story) {
		Optional<Story> storyData = storyDao.findById(issueId);
		Story existingStory = null;
		if (storyData.isPresent()) {
			existingStory = storyData.get();
			// Update existing story with new data
			existingStory.setTitle(story.getTitle());
			existingStory.setDescription(story.getDescription());
			existingStory.setCreateDt(
					Objects.nonNull(story.getCreateDt()) ? story.getCreateDt() : existingStory.getCreateDt());
			existingStory.setEstPointVal(
					Objects.nonNull(story.getEstPointVal()) ? story.getEstPointVal() : existingStory.getEstPointVal());
			if (Status.COMPLETED.equals(story.getStatus())) {
				existingStory.setStatus(Status.COMPLETED);
			} else if (Objects.nonNull(story.getEstPointVal()) || Status.ESTIMATED.equals(existingStory.getStatus())) {
				existingStory.setStatus(Status.ESTIMATED);
			} else {
				existingStory.setStatus(Status.NEW);
			}
			storyDao.save(existingStory);
		}
		return existingStory;
	}

	public void deleteStory(long issueId) {
		storyDao.deleteById(issueId);
	}

	public void deleteAllStories() {
		storyDao.deleteAll();
	}

}
