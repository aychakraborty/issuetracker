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

import com.pinguin.issuetracker.entity.Developer;
import com.pinguin.issuetracker.handler.DeveloperHandler;

@SpringBootTest
public class DeveloperControllerTest {

	@InjectMocks
	DeveloperController devController;

	@Mock
	DeveloperHandler devHandler;

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
		Mockito.when(this.devHandler.getListOfDevelopers()).thenReturn(devList);
		Assert.assertNotNull(this.devController.getListOfDevelopers());
	}

	@Test
	@org.junit.Test
	public void addDevTest() {
		Developer dev = new Developer();
		Mockito.when(this.devHandler.addDeveloper(Mockito.any(Developer.class))).thenReturn(new Developer());
		Assert.assertNotNull(this.devController.addDeveloper(dev));
	}

	@Test
	@org.junit.Test
	public void updateDevTest() {
		Developer dev = new Developer();
		Mockito.when(this.devHandler.updateDeveloper(Mockito.anyLong(), Mockito.any(Developer.class)))
				.thenReturn(new Developer());
		Assert.assertNotNull(this.devController.updateDeveloper(1, dev));
	}

	@Test
	@org.junit.Test
	public void deleteDevTest() {
		Assert.assertNotNull(this.devController.deleteDeveloper(1));
	}

	@Test
	@org.junit.Test
	public void deleteAllDevs() {
		Assert.assertNotNull(this.devController.deleteAllDevelopers());
	}

}
