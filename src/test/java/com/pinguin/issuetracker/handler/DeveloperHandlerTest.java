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
import com.pinguin.issuetracker.entity.Developer;

@SpringBootTest
public class DeveloperHandlerTest {

	@InjectMocks
	DeveloperHandler developerHandler;

	@Mock
	DeveloperDao developerDao;

	@Before
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@org.junit.Test
	public void getListOfDeveloperTest() {
		Developer dev = new Developer();
		List<Developer> devList = new ArrayList<>();
		devList.add(dev);
		Mockito.when(this.developerDao.findAll()).thenReturn(devList);
		Assert.assertNotNull(this.developerHandler.getListOfDevelopers());
	}

	@Test
	@org.junit.Test
	public void addDevTest() {
		Developer dev = new Developer();
		Mockito.when(this.developerDao.save(Mockito.any(Developer.class))).thenReturn(new Developer());
		Assert.assertNotNull(this.developerHandler.addDeveloper(dev));
	}

	@Test
	@org.junit.Test
	public void updateDevTest() {
		Developer dev = new Developer();
		Mockito.when(this.developerDao.findById(Mockito.anyLong())).thenReturn(Optional.of(dev));
		Mockito.when(this.developerDao.save(Mockito.any(Developer.class))).thenReturn(new Developer());
		Assert.assertNotNull(this.developerHandler.updateDeveloper(1, dev));
	}

	@org.junit.Test(expected = RuntimeException.class)
	public void deleteDevTest() {
		Mockito.when(this.developerDao.findById(Mockito.anyLong())).thenThrow(RuntimeException.class);
		this.developerHandler.deleteDeveloper(1);
	}

}
