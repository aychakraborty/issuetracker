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

import com.pinguin.issuetracker.entity.Bug;
import com.pinguin.issuetracker.handler.BugHandler;

@SpringBootTest
public class BugControllerTest {

	@InjectMocks
	BugController bugController;

	@Mock
	BugHandler bugHandler;

	@Before
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@org.junit.Test
	public void getBugByIssueIdTest() {
		Mockito.when(this.bugHandler.getBugByIssueId(Mockito.anyLong())).thenReturn(new Bug());
		Assert.assertNotNull(this.bugController.getBugByIssueId(1));
	}

	@Test
	@org.junit.Test
	public void getListOfBugsTest() {
		Bug bug = new Bug();
		List<Bug> bugList = new ArrayList<>();
		bugList.add(bug);
		Mockito.when(this.bugHandler.getListOfBugs()).thenReturn(bugList);
		Assert.assertNotNull(this.bugController.getListOfBugs());
	}

	@Test
	@org.junit.Test
	public void addBugTest() {
		Bug bug = new Bug();
		Mockito.when(this.bugHandler.addBug(Mockito.any(Bug.class))).thenReturn(new Bug());
		Assert.assertNotNull(this.bugController.addBug(bug));
	}

	@Test
	@org.junit.Test
	public void updateBugTest() {
		Bug bug = new Bug();
		Mockito.when(this.bugHandler.updateBug(Mockito.anyLong(), Mockito.any(Bug.class))).thenReturn(new Bug());
		Assert.assertNotNull(this.bugController.updateBug(1, bug));
	}

	@Test
	@org.junit.Test
	public void deleteBugTest() {
		Assert.assertNotNull(this.bugController.deleteBug(1));
	}

	@Test
	@org.junit.Test
	public void deleteAllBugs() {
		Assert.assertNotNull(this.bugController.deleteAllBugs());
	}

}
