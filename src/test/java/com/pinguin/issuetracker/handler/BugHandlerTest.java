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

import com.pinguin.issuetracker.dao.BugDao;
import com.pinguin.issuetracker.dao.DeveloperDao;
import com.pinguin.issuetracker.entity.Bug;
import com.pinguin.issuetracker.entity.Developer;

@SpringBootTest
public class BugHandlerTest {

	@InjectMocks
	BugHandler bugHandler;

	@Mock
	BugDao bugDao;
	
	@Mock
	DeveloperDao devDao;

	@Before
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@org.junit.Test
	public void getBugByIssueIdTest() {
		Mockito.when(this.bugDao.findById(Mockito.anyLong())).thenReturn(Optional.of(new Bug()));
		Assert.assertNotNull(this.bugHandler.getBugByIssueId(1));
	}

	@Test
	@org.junit.Test
	public void getListOfBugsTest() {
		Bug bug = new Bug();
		List<Bug> bugList = new ArrayList<>();
		bugList.add(bug);
		Mockito.when(this.bugDao.findAll()).thenReturn(bugList);
		Assert.assertNotNull(this.bugHandler.getListOfBugs());
	}

	@Test
	@org.junit.Test
	public void addBugTest() {
		Bug bug = new Bug();
		Mockito.when(this.bugDao.save(Mockito.any(Bug.class))).thenReturn(new Bug());
		Assert.assertNotNull(this.bugHandler.addBug(bug));
	}

	@Test
	@org.junit.Test
	public void updateBugTest() {
		Bug bug = new Bug();
		bug.setDevName("A");
		Developer dev = new Developer();
		dev.setId(1);
		dev.setName("A");
		List<Developer> devList = new ArrayList<>();
		devList.add(dev);
		Mockito.when(this.bugDao.save(Mockito.any(Bug.class))).thenReturn(new Bug());
		Mockito.when(this.devDao.findAll()).thenReturn(devList);
		Mockito.when(this.bugDao.findById(Mockito.anyLong())).thenReturn(Optional.of(bug));
		Assert.assertNotNull(this.bugHandler.updateBug(1, bug));
	}

	@org.junit.Test(expected = RuntimeException.class)
	public void deleteBugTest() {
		Mockito.when(this.bugDao.findById(Mockito.anyLong())).thenThrow(RuntimeException.class);
		this.bugHandler.deleteBug(5);
	}

}
