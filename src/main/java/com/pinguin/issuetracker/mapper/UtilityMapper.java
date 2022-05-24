package com.pinguin.issuetracker.mapper;

import com.pinguin.issuetracker.dto.DeveloperDto;
import com.pinguin.issuetracker.entity.Developer;

/**
 * @author Chakraborty, Ayan
 */
public class UtilityMapper {

	/**
	 * This converts developer entity to developer DTO
	 * 
	 * @param developer
	 * @return DeveloperDto
	 */
	public static DeveloperDto mapDeveloperEntityToDeveloperDto(Developer developer) {
		DeveloperDto developerDto = new DeveloperDto();
		developerDto.setId(developer.getId());
		developerDto.setName(developer.getName());
		developerDto.setPointsPicked(0);
		return developerDto;
	}

}
