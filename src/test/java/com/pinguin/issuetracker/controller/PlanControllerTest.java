package com.pinguin.issuetracker.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pinguin.issuetracker.dto.PlanDto;
import com.pinguin.issuetracker.handler.PlanHandler;

@SpringBootTest
public class PlanControllerTest {

	@InjectMocks
	PlanController planController;

	@Mock
	PlanHandler planHandler;

	@Before
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@org.junit.Test
	public void getPlanTest() {
		Mockito.when(this.planHandler.fetchPlan()).thenReturn(new PlanDto());
		Assert.assertNotNull(this.planController.getPlan());
	}

}
