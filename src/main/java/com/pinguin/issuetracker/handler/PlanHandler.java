package com.pinguin.issuetracker.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinguin.issuetracker.dao.BugDao;
import com.pinguin.issuetracker.dao.DeveloperDao;
import com.pinguin.issuetracker.dao.StoryDao;
import com.pinguin.issuetracker.dto.DeveloperDto;
import com.pinguin.issuetracker.dto.PlanDto;
import com.pinguin.issuetracker.entity.Bug;
import com.pinguin.issuetracker.entity.Developer;
import com.pinguin.issuetracker.entity.Story;
import com.pinguin.issuetracker.enums.Status;
import com.pinguin.issuetracker.mapper.UtilityMapper;

/**
 * @author Chakraborty, Ayan
 */
@Service
public class PlanHandler {

	@Autowired
	DeveloperDao developerDao;

	@Autowired
	StoryDao storyDao;

	@Autowired
	BugDao bugDao;

	public static final Integer MAX_DEV_STORY_POINT = 10; // Max Story Point per Developer

	public PlanDto fetchPlan() {
		PlanDto plan = new PlanDto();
		List<Developer> devList = developerDao.findAll();
		if (devList.isEmpty()) {
			throw new RuntimeException("Please add developers before creating plan.");
		}
		List<DeveloperDto> devDtoList = new ArrayList<>();
		for (Developer dev : devList) {
			// Convert Entity to DTO to represent developer object
			devDtoList.add(UtilityMapper.mapDeveloperEntityToDeveloperDto(dev));
		}
		// Set the list of developers
		plan.setDevList(devDtoList);
		List<Bug> bugList = bugDao.findAll();
		// Set the list of bugs
		plan.setBugList(bugList);

		List<Story> storyList = storyDao.findAll();
		// Filter out list of stories which are estimated and sort it by descending
		// order to finish off bigger stories at first which will help complete stories
		// in minimum weeks
		List<Story> estimatedStoryList = storyList.stream().filter(story -> story.getStatus().equals(Status.ESTIMATED))
				.sorted((f1, f2) -> Integer.compare(f2.getEstPointVal(), f1.getEstPointVal()))
				.collect(Collectors.toList());
		// Filter out list of completed stories
		List<Story> completedStoryList = storyList.stream().filter(story -> story.getStatus().equals(Status.COMPLETED))
				.collect(Collectors.toList());
		List<Story> plannedStoryList = new ArrayList<>();
		for (DeveloperDto dev : devDtoList) {
			// Loop in for each developer, finish his capacity which is 10 and then move to
			// the next developer
			int totalPointsPicked = 0;
			for (Story story : estimatedStoryList) {
				// Loop in for each story, check if the story is not assigned and developer's
				// capacity of 10 has not reached
				if (Objects.isNull(story.getDevName()) && dev.getPointsPicked() < MAX_DEV_STORY_POINT) {
					// Store capacity points left for the developer in a temporary variable
					int pointsLeft = MAX_DEV_STORY_POINT - dev.getPointsPicked();
					// Check if developer's capacity is there to take more stories
					if (pointsLeft >= story.getEstPointVal()) {
						// If yes, add new points to previous capacity points
						totalPointsPicked += story.getEstPointVal();
						// Assign story to developer
						story.setDevName(dev.getName());
						// Set developer's new capacity point
						dev.setPointsPicked(totalPointsPicked);
						// Add story to list of planned stories
						plannedStoryList.add(story);
					}
				}
			}
		}
		// Set all planned stories
		plan.setPlannedStoryList(plannedStoryList);
		// Set all completed stories
		plan.setCompletedStoryList(completedStoryList);
		// Remove planned stories from original story list
		storyList.removeAll(plannedStoryList);
		// Remove completed stories from original story list
		storyList.removeAll(completedStoryList);
		// Remaining stories are set to backlog list
		plan.setBacklogStoryList(storyList);
		// Return the final plan
		return plan;
	}

}
