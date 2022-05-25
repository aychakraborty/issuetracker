package com.pinguin.issuetracker.handler;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pinguin.issuetracker.dao.BugDao;
import com.pinguin.issuetracker.dao.DeveloperDao;
import com.pinguin.issuetracker.dao.StoryDao;
import com.pinguin.issuetracker.entity.Bug;
import com.pinguin.issuetracker.entity.Developer;
import com.pinguin.issuetracker.entity.Story;
import com.pinguin.issuetracker.enums.Status;

@SpringBootTest
public class PlanHandlerTest {

	@InjectMocks
	PlanHandler planHandler;
	
	@Mock
	DeveloperDao developerDao;
	
	@Mock
	StoryDao storyDao;
	
	@Mock
	BugDao bugDao;
	
	@Before
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@org.junit.Test
	public void fetchPlanTest() {
		Developer dev = new Developer();
		List<Developer> devList = new ArrayList<>();
		devList.add(dev);
		Mockito.when(this.developerDao.findAll()).thenReturn(devList);
		Bug bug = new Bug();
		List<Bug> bugList = new ArrayList<>();
		bugList.add(bug);
		Mockito.when(this.bugDao.findAll()).thenReturn(bugList);
		Story story = new Story();
		story.setStatus(Status.NEW);
		List<Story> storyList = new ArrayList<>();
		storyList.add(story);
		Mockito.when(this.storyDao.findAll()).thenReturn(storyList);
		Assert.assertNotNull(this.planHandler.fetchPlan());
	}
	
}
