package com.pinguin.issuetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinguin.issuetracker.dto.PlanDto;
import com.pinguin.issuetracker.handler.PlanHandler;

/**
 * @author Chakraborty, Ayan
 */
@RestController
public class PlanController {

	@Autowired
	PlanHandler planHandler;

	/**
	 * This API is used to create and fetch Plan
	 * 
	 * @return ResponseEntity<PlanDto>
	 */
	@GetMapping(value = "/plan")
	public ResponseEntity<PlanDto> getPlan() {
		PlanDto planDto = planHandler.fetchPlan();
		return new ResponseEntity<>(planDto, HttpStatus.OK);
	}

}
