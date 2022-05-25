package com.pinguin.issuetracker.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pinguin.issuetracker.dao.DeveloperDao;
import com.pinguin.issuetracker.dao.StoryDao;
import com.pinguin.issuetracker.entity.Story;

@SpringBootTest
public class StoryHandlerTest {

	@InjectMocks
	StoryHandler storyHandler;

	@Mock
	StoryDao storyDao;

	@Mock
	DeveloperDao devDao;

	@Before
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@org.junit.Test
	public void getStoryByIssueIdTest() {
		Mockito.when(this.storyDao.findById(Mockito.anyLong())).thenReturn(Optional.of(new Story()));
		Assert.assertNotNull(this.storyHandler.getStoryByIssueId(1));
	}

	@Test
	@org.junit.Test
	public void getListOfStoriesTest() {
		Story story = new Story();
		List<Story> storyList = new ArrayList<>();
		storyList.add(story);
		Mockito.when(this.storyDao.findAll()).thenReturn(storyList);
		Assert.assertNotNull(this.storyHandler.getListOfStories());
	}

	@Test
	@org.junit.Test
	public void addStoryTest() {
		Story story = new Story();
		Mockito.when(this.storyDao.save(Mockito.any(Story.class))).thenReturn(new Story());
		Assert.assertNotNull(this.storyHandler.addStory(story));
	}

	@Test
	@org.junit.Test
	public void updateStoryTest() {
		Story story = new Story();
		story.setIssueId(1);
		story.setDescription("Story 1");
		Mockito.when(this.storyDao.findById(Mockito.anyLong())).thenReturn(Optional.of(new Story()));
		Mockito.when(this.storyDao.save(Mockito.any(Story.class))).thenReturn(new Story());
		Assert.assertNotNull(this.storyHandler.updateStory(1, story));
	}

	@org.junit.Test(expected = RuntimeException.class)
	public void deleteStoryTest() {
		Mockito.when(this.storyDao.findById(Mockito.anyLong())).thenThrow(RuntimeException.class);
		this.storyHandler.deleteStory(1);
	}

}
