package com.pinguin.issuetracker.controller;

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

import com.pinguin.issuetracker.entity.Story;
import com.pinguin.issuetracker.handler.StoryHandler;

@SpringBootTest
public class StoryControllerTest {

	@InjectMocks
	StoryController storyController;

	@Mock
	StoryHandler storyHandler;

	@Before
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@org.junit.Test
	public void getStoryByIssueIdTest() {
		Mockito.when(this.storyHandler.getStoryByIssueId(Mockito.anyLong())).thenReturn(new Story());
		Assert.assertNotNull(this.storyController.getStoryByIssueId(1));
	}

	@Test
	@org.junit.Test
	public void getListOfStoriesTest() {
		Story story = new Story();
		List<Story> storyList = new ArrayList<>();
		storyList.add(story);
		Mockito.when(this.storyHandler.getListOfStories()).thenReturn(storyList);
		Assert.assertNotNull(this.storyController.getListOfStories());
	}

	@Test
	@org.junit.Test
	public void addStoryTest() {
		Story story = new Story();
		Mockito.when(this.storyHandler.addStory(Mockito.any(Story.class))).thenReturn(new Story());
		Assert.assertNotNull(this.storyController.addStory(story));
	}

	@Test
	@org.junit.Test
	public void updateStoryTest() {
		Story story = new Story();
		Mockito.when(this.storyHandler.updateStory(Mockito.anyLong(), Mockito.any(Story.class))).thenReturn(new Story());
		Assert.assertNotNull(this.storyController.updateStory(1, story));
	}

	@Test
	@org.junit.Test
	public void deleteStoryTest() {
		Assert.assertNotNull(this.storyController.deleteStory(1));
	}

	@Test
	@org.junit.Test
	public void deleteAllStories() {
		Assert.assertNotNull(this.storyController.deleteAllStories());
	}

}
